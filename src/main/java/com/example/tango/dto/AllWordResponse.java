package com.example.tango.dto;

import com.example.tango.Model.Word;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
public class AllWordResponse {
    String message;
    int code;
    ArrayList<Word> words;
}
