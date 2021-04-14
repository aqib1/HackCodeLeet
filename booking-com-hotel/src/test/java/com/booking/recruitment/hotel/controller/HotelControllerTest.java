package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.repository.CityRepository;
import com.booking.recruitment.hotel.repository.HotelRepository;
import com.booking.testing.SlowTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql")
@SlowTest
class HotelControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private HotelRepository repository;
    @Autowired
    private CityRepository cityRepository;

    @Test
    @DisplayName("When all hotels are requested then they are all returned")
    void allHotelsRequested() throws Exception {
        mockMvc
                .perform(get("/hotel"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize((int) repository.count())));
    }

    @Test
    @DisplayName("When a hotel creation is requested then it is persisted")
    void hotelCreatedCorrectly() throws Exception {
        City city =
                cityRepository
                        .findById(1L)
                        .orElseThrow(
                                () -> new IllegalStateException("Test dataset does not contain a city with ID 1!"));
        Hotel newHotel = Hotel.builder().setName("This is a test hotel").setCity(city).build();

        Long newHotelId =
                mapper
                        .readValue(
                                mockMvc
                                        .perform(
                                                post("/hotel")
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .content(mapper.writeValueAsString(newHotel)))
                                        .andExpect(status().isCreated())
                                        .andReturn()
                                        .getResponse()
                                        .getContentAsString(),
                                Hotel.class)
                        .getId();

        newHotel.setId(newHotelId); // Populate the ID of the hotel after successful creation

        assertThat(
                repository
                        .findById(newHotelId)
                        .orElseThrow(
                                () -> new IllegalStateException("New Hotel has not been saved in the repository")),
                equalTo(newHotel));
    }

    @Test
    @DisplayName("When a hotel is requested against an id then it returned successfully")
    void getHotelById() throws Exception {
        mockMvc
                .perform(get("/hotel/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Monaghan Hotel"))
                .andExpect(jsonPath("$.rating").value(9.2))
                .andExpect(jsonPath("$.city.id").value(1))
                .andExpect(jsonPath("$.city.name").value("Amsterdam"));
    }

    @Test
    @DisplayName("When a hotel is requested against Unknown id then it returned error response")
    void getHotelForUnknownId() throws Exception {
        mockMvc
                .perform(get("/hotel/50"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.detailedMessage").value("Hotel not exists against id = 50 [Internal server exception! => (HotelNotFoundException)]"))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.errorMessage").value("Hotel not exists against id = 50"))
                .andExpect(jsonPath("$.exceptionName").value("com.booking.recruitment.hotel.exception.HotelNotFoundException"));
    }

    @Test
    @DisplayName("When a hotel is deleted against id then it should delete successfully")
    void deleteHotelById() throws Exception {
        mockMvc
                .perform(delete("/hotel/5"))
                .andExpect(status().isNoContent())
                .andDo(print());
        Hotel hotel = mapper.readValue(mockMvc.perform(get("/hotel/5"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString(), Hotel.class);
        assertTrue(hotel.isDeleted());
    }

  @Test
  @DisplayName("When a hotel is deleted against unknown id then it returned error response")
  void deleteHotelByUnknownId() throws Exception {
    mockMvc.perform(delete("/hotel/50"))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.detailedMessage").value("Hotel not exists against id = 50 [Internal server exception! => (HotelNotFoundException)]"))
            .andExpect(jsonPath("$.errorCode").value(404))
            .andExpect(jsonPath("$.errorMessage").value("Hotel not exists against id = 50"))
            .andExpect(jsonPath("$.exceptionName").value("com.booking.recruitment.hotel.exception.HotelNotFoundException"));
  }
}
