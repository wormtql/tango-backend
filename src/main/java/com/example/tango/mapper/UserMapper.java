package com.example.tango.mapper;

import com.example.tango.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
public interface UserMapper {
    @Select("select * from users where username=#{name}")
    User selectUserByName(String name);

    @Insert("insert into users (username, password) values ('${name}', '${password}')")
    void insertUser(String name, String password);
}
