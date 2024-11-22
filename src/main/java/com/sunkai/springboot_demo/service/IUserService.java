package com.sunkai.springboot_demo.service;

import com.sunkai.springboot_demo.pojo.User;
import com.sunkai.springboot_demo.pojo.dto.UserDto;

public interface IUserService {
    User add(UserDto user);

    
    User getUser(Integer userId);

    User edit(UserDto user);

    void delete(Integer userId);
}
