package com.booking.recruitment.hotel.dto;

import com.booking.recruitment.hotel.model.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponseDto {
	private int id;
	private String name;
	private double rating;
	private double latitude;
	private double longitude;
	private String address;
	private City city;
}
