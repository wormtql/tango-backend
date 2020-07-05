package com.example.tango.dto;

import com.example.tango.Model.Word;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateWordResponse {
    private String message;
    private int code;
    private Word word;
}
