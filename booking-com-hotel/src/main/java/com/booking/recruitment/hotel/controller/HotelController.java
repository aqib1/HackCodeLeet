package com.booking.recruitment.hotel.controller;

import com.booking.recruitment.hotel.model.Hotel;
import com.booking.recruitment.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.booking.recruitment.hotel.utilities.Constants.HOTEL_BASE_URL;
import static com.booking.recruitment.hotel.utilities.Constants.HOTEL_BY_ID_URL;

@RestController
@RequestMapping(HOTEL_BASE_URL)
public class HotelController {
  private final HotelService hotelService;

  @Autowired
  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Hotel> getAllHotels() {
    return hotelService.getAllHotels();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Hotel createHotel(@RequestBody Hotel hotel) {
    return hotelService.createNewHotel(hotel);
  }

  @GetMapping(HOTEL_BY_ID_URL)
  @ResponseStatus(HttpStatus.OK)
  public Hotel getHotelById(@PathVariable Long id) {
    return hotelService.getHotelById(id);
  }

  @DeleteMapping(HOTEL_BY_ID_URL)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteHotelById(@PathVariable Long id) {
      hotelService.deleteHotelById(id);
  }
}
