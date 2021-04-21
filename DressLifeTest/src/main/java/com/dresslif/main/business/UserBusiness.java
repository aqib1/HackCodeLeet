package com.dresslif.main.business;

import com.dresslif.main.domain.AllUserResponse;
import com.dresslif.main.domain.UserDetailedResponse;
import com.dresslif.main.domain.UserResponse;
import com.dresslif.main.service.RestUserServiceImpl;
import org.apache.catalina.startup.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.dresslif.main.utils.Helper.LIMIT_REQUESTS_FOR_USERS;

@Component
public class UserBusiness {

    @Autowired
    private RestUserServiceImpl restUserService;

    public AllUserResponse getAllUsers() {
        List<UserResponse> userResponseList = new ArrayList<>();
        IntStream.rangeClosed(1, LIMIT_REQUESTS_FOR_USERS).forEach(i ->
            userResponseList.add(restUserService.getUserById(i)));

        return AllUserResponse.builder()
                .userResponseList(userResponseList)
                .build();
    }

    public UserDetailedResponse getAllDetailedUsers() {
        List<UserResponse> userResponseList = getAllUsers().getUserResponseList();

        List<String> titleWords = new ArrayList<>();
        userResponseList.forEach(userResponse ->
                titleWords.addAll(Arrays.asList(userResponse.getTitle().split(" "))));

        List<String> bodyWords = new ArrayList<>();

        userResponseList.forEach(userResponse ->
            bodyWords.addAll(Arrays.asList(userResponse.getBody().split(" "))));

        Set<String> common = titleWords
                .stream()
                .filter(title -> bodyWords.contains(title))
                .collect(Collectors.toSet());

        return UserDetailedResponse.builder()
                .titleWords(titleWords)
                .bodyWords(bodyWords)
                .commonWords(common)
                .build();
    }
}
