package com.example.tango.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {
    String name;
    String description;
    int isPublic;
    String token;
}
