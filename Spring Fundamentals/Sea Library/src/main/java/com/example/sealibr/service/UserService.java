package com.example.sealibrary.service;

import com.example.sealibrary.web.dto.UserRegistrationDto;
import com.example.sealibrary.model.User;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
