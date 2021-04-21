package com.dresslif.main.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Helper {

    public static final int LIMIT_REQUESTS_FOR_USERS = 10;

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    public static  String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T jsonToObject(String value, Class<T> classRef) {
        try {
            return objectMapper.readValue(value, classRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Helper() {

    }
}
