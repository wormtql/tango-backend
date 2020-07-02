package com.example.tango;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.tango.mapper")
public class TangoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TangoApplication.class, args);
    }

}
