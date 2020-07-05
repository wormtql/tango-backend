package com.example.tango.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteWordRequest {
    private int id;
    private String token;
}
