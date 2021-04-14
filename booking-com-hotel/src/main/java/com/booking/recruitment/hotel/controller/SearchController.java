package com.booking.recruitment.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.recruitment.hotel.dto.SearchResponseDto;
import com.booking.recruitment.hotel.service.impl.DefaultSearchService;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	private static final String SEARCH_HOTEL_URL = "/search/{cityId}/";
	
	@Autowired
	private DefaultSearchService searchService;
	
	@GetMapping(SEARCH_HOTEL_URL)
	public ResponseEntity<List<SearchResponseDto>> searchHotels(@PathVariable("cityId") Long cityId, @RequestParam("sortedBy") int distance) {
		return ResponseEntity.ok(searchService.findTopClosestHotels(cityId,distance));
	}
 
}
