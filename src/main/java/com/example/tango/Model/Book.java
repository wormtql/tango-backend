package com.example.tango.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    // book id
    private int id;
    // user id
    private int userId;
    // book name
    private String name;
    // stars
    private int star;
    // forks
    private int fork;
    // is public
    private int is_public;
    // description
    private String description;
}
