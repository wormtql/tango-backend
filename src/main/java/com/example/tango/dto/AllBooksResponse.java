package com.example.tango.dto;

import com.example.tango.Model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
public class AllBooksResponse {
    private ArrayList<Book> books;
    private int code;
    private String message;
}
