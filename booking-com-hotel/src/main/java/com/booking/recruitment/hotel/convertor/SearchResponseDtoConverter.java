package com.booking.recruitment.hotel.convertor;

import org.springframework.core.convert.converter.Converter;

import com.booking.recruitment.hotel.dto.SearchResponseDto;
import com.booking.recruitment.hotel.model.Hotel;

public class SearchResponseDtoConverter implements Converter<Hotel, SearchResponseDto> {

    @Override
    public SearchResponseDto convert(Hotel source) {
        // TODO Auto-generated method stub
        return null;
    }

}
