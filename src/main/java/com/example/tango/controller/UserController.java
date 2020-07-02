package com.example.tango.controller;

import com.example.tango.dto.CommonResponseObject;
import com.example.tango.dto.LoginRequest;
import com.example.tango.dto.LoginResponse;
import com.example.tango.dto.SignUpObject;
import com.example.tango.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign_up")
    public CommonResponseObject signUp(@RequestBody SignUpObject signUpObject) {
        return userService.signUp(signUpObject);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
