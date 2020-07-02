package com.example.tango.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateWordRequest {
    private String token;
    private String s1;
    private String s2;
    private String attribute;
    private String pronunciation;
    private int bookId;
}
