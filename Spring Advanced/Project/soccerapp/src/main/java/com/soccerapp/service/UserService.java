package com.soccerapp.service;

import com.soccerapp.model.UserLoginBindingModel;
import com.soccerapp.model.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();

}
