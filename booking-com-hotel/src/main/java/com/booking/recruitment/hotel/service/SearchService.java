package com.booking.recruitment.hotel.service;

import java.util.List;

import com.booking.recruitment.hotel.dto.SearchResponseDto;

public interface SearchService {
	List<SearchResponseDto> findTopClosestHotels(Long city, int distance);
}
