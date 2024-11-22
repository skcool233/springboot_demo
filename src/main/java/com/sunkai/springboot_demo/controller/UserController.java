package com.sunkai.springboot_demo.controller;

import com.sunkai.springboot_demo.pojo.ResponseMessage;
import com.sunkai.springboot_demo.pojo.User;
import com.sunkai.springboot_demo.pojo.dto.UserDto;
import com.sunkai.springboot_demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController //接口方法返回对象,转换成json文本
@RequestMapping("/user")   //localhost:8080/user/**
public class UserController {

    @Autowired
    IUserService userService;

    //增
    @PostMapping   //URL: localhost:8080/user  method: POST
    public ResponseMessage add(@Validated @RequestBody UserDto user){
        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
    }

    //查询
    @GetMapping("/{userId}")   //URL: localhost:8080/user/1  method: GET
    public ResponseMessage get(@PathVariable Integer userId){
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    //修改
    @PutMapping  //URL: localhost:8080/user  method: PUT
    public ResponseMessage edit(@Validated @RequestBody UserDto user){
        User userNew = userService.edit(user);
        return ResponseMessage.success(userNew);
    }

    //删除
    @DeleteMapping("/{userId}")
    public ResponseMessage delete(@PathVariable Integer userId){
        userService.delete(userId);
        return ResponseMessage.success();
    }

}
