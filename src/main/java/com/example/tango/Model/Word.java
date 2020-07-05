package com.example.tango.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Word {
    private String s1;
    private String s2;
    // 词性
    private String attribute;
    private String pronunciation;

    private int bookId;
    private int userId;
    private int id;
}
