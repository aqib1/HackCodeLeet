package com.booking.recruitment.hotel.service.impl;

import java.util.*;

import com.booking.recruitment.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.recruitment.hotel.dto.SearchResponseDto;
import com.booking.recruitment.hotel.model.City;
import com.booking.recruitment.hotel.repository.CityRepository;
import com.booking.recruitment.hotel.repository.HotelRepository;
import com.booking.recruitment.hotel.service.SearchService;

@Service
public class DefaultSearchService implements SearchService {
	
	@Autowired
	private HotelRepository hotelRepo;
	@Autowired
	private CityRepository cityRepo;

	 

	@Override
	public List<SearchResponseDto> findTopClosestHotels(Long city,int distance) {
		City cityEntity = cityRepo.findById(city).orElseThrow(() -> new RuntimeException());

		getClosestHotels(cityEntity);
		return null;
	}

	private List<Hotel> getClosestHotels(City city){
		List<Hotel> hotels = hotelRepo.findAll();
		Queue<Map<Double, Hotel>> minHeap = new PriorityQueue<>();
		Map<Double, Hotel> mapData = new HashMap<>();
		for(Hotel hotel : hotels) {
			final int R = 6371; // Radious of the earth
			Double lat1 = city.getCityCentreLatitude();
			Double lon1 = city.getCityCentreLongitude();
			Double lat2 = hotel.getLatitude();
			Double lon2 = hotel.getLongitude();
			Double latDistance = toRad(lat2-lat1);
			Double lonDistance = toRad(lon2-lon1);
			Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
			Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
			Double distance = R * c;
			mapData.put(distance, hotel);
		}
		List<Hotel> result = new ArrayList<>();
		for(int x=0; x<3 && !minHeap.isEmpty(); x++) {
			result.add(minHeap.poll().get(0));
		}
		return result;
	}

	private static Double toRad(Double value) {
		return value * Math.PI / 180;
	}


}
