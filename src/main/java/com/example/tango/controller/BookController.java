package com.example.tango.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.tango.dto.*;
import com.example.tango.service.BookService;
import com.example.tango.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@CrossOrigin
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public CommonResponseObject create(@RequestBody CreateBookRequest createBookRequest) {
        String token = createBookRequest.getToken();

        DecodedJWT decodedJWT = JwtUtils.verify(token);
        if (decodedJWT == null) {
            return new CommonResponseObject(1000, "not authenticated");
        }

        int userId = JwtUtils.getUserId(decodedJWT);

        String name = createBookRequest.getName();
        String description = createBookRequest.getDescription();
        int isPublic = createBookRequest.getIsPublic();

        return bookService.createBook(name, description, isPublic, userId);
    }

    @DeleteMapping("/delete")
    public CommonResponseObject delete(@RequestBody DeleteBookRequest deleteBookRequest) {
        String token = deleteBookRequest.getToken();

        DecodedJWT decodedJWT = JwtUtils.verify(token);
        if (decodedJWT == null) {
            return new CommonResponseObject(1000, "not authenticated");
        }

        int userId = JwtUtils.getUserId(decodedJWT);

        String name = deleteBookRequest.getName();

        return bookService.deleteBook(name, userId);
    }

    @GetMapping("/all")
    public AllBooksResponse getAll(@RequestParam String token) {
//        String token = allBooksRequest.getToken();

        DecodedJWT decodedJWT = JwtUtils.verify(token);
        if (decodedJWT == null) {
            return new AllBooksResponse(null, 1000, "not authenticated");
        }

        int userId = JwtUtils.getUserId(decodedJWT);

        return bookService.getAllBooks(userId);
    }
}
