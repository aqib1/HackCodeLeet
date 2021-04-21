package com.dresslif.main.service;

import com.dresslif.main.domain.UserResponse;

public interface RestUserService {
    UserResponse getUserById(int id);
}
