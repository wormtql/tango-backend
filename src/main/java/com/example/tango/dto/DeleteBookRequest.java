package com.example.tango.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteBookRequest {
    private String token;
    private String name;
}
