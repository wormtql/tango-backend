package com.example.tango.service;

import com.example.tango.Model.User;
import com.example.tango.dto.CommonResponseObject;
import com.example.tango.dto.LoginRequest;
import com.example.tango.dto.LoginResponse;
import com.example.tango.dto.SignUpObject;
import com.example.tango.mapper.UserMapper;
import com.example.tango.util.JwtUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public CommonResponseObject signUp(SignUpObject signUpObject) {
        User user = userMapper.selectUserByName(signUpObject.getUsername());
        if (user != null) {
            return new CommonResponseObject(1000, "username already used");
        }

        String encodedPassword = DigestUtils.md5Hex(signUpObject.getPassword());
        userMapper.insertUser(signUpObject.getUsername(), encodedPassword);

        return new CommonResponseObject(200, "ok");
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userMapper.selectUserByName(loginRequest.getUsername());
        if (user == null) {
            return new LoginResponse(1000, "wrong username or password", "");
        }

        String encodedPassword = DigestUtils.md5Hex(loginRequest.getPassword());
        if (!encodedPassword.equals(user.getPassword())) {
            return new LoginResponse(1000, "wrong username or password", "");
        }

        String token = JwtUtils.create(loginRequest.getUsername(), user.getId());
        return new LoginResponse(200, "ok", token);
    }
}
