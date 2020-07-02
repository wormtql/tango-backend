package com.example.tango.service;

import com.example.tango.Model.Book;
import com.example.tango.dto.AllBooksResponse;
import com.example.tango.dto.CommonResponseObject;
import com.example.tango.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    private BookMapper bookMapper;

    @Autowired
    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public CommonResponseObject createBook(String name, String des, int isPublic, int userId) {
        Book book = bookMapper.selectBookByNameAndUserId(name, userId);
        if (book != null) {
            return new CommonResponseObject(1000, "book already exists");
        }

        bookMapper.insertBook(name, des, userId, isPublic != 0 ? 1 : 0);
        return new CommonResponseObject(200, "ok");
    }

    public CommonResponseObject deleteBook(String name, int userId) {
        Book book = bookMapper.selectBookByNameAndUserId(name, userId);
        if (book == null) {
            return new CommonResponseObject(1000, "book not exists");
        }

        bookMapper.deleteByNameAndUserId(name, userId);
        return new CommonResponseObject(200, "ok");
    }

    public AllBooksResponse getAllBooks(int userId) {
        ArrayList<Book> ret = bookMapper.selectAllBooksByUserId(userId);

        return new AllBooksResponse(ret, 200, "ok");
    }
}
