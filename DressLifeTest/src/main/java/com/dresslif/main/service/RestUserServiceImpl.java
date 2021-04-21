package com.dresslif.main.service;

import com.dresslif.main.domain.UserResponse;
import com.dresslif.main.exceptions.ErrorResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.dresslif.main.utils.Helper.jsonToObject;
import static com.dresslif.main.utils.URL.USER_DETAILS_URL;

@Service
public class RestUserServiceImpl implements RestUserService {

    private RestTemplate caller;

    @Override
    public UserResponse getUserById(int id) {
       ResponseEntity<String> responseEntity = caller.getForEntity(USER_DETAILS_URL, String.class);
       if(responseEntity.getStatusCode() == HttpStatus.NOT_MODIFIED) {
            return jsonToObject(responseEntity.getBody(), UserResponse.class);
        }
        throw new ErrorResponseException("Error response received ["+ responseEntity.getStatusCode()+"]");
    }
}
