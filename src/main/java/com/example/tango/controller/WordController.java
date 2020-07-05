package com.example.tango.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.tango.dto.*;
import com.example.tango.service.WordService;
import com.example.tango.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/word")
@CrossOrigin
public class WordController {
    private WordService wordService;

    @Autowired
    public WordController(@RequestBody WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping("/create")
    public CreateWordResponse create(@RequestBody CreateWordRequest createWordRequest) {
        String token = createWordRequest.getToken();

        DecodedJWT decodedJWT = JwtUtils.verify(token);
        if (decodedJWT == null) {
            return new CreateWordResponse("not authenticated", 1000, null);
        }

        int userId = JwtUtils.getUserId(decodedJWT);

        int bookId = createWordRequest.getBookId();
        String s1 = createWordRequest.getS1();
        String s2 = createWordRequest.getS2();
        String attr = createWordRequest.getAttribute();
        String pro = createWordRequest.getPronunciation();

        return wordService.create(userId, bookId, s1, s2, attr, pro);
    }

    @PostMapping("/all")
    public AllWordResponse all(@RequestBody AllWordRequest allWordRequest) {
        String token = allWordRequest.getToken();

        DecodedJWT decodedJWT = JwtUtils.verify(token);
        if (decodedJWT == null) {
            return new AllWordResponse("not authenticated", 1000, null);
        }

        int userId = JwtUtils.getUserId(decodedJWT);

        int bookId = allWordRequest.getId();

//        System.out.println(userId);
        return wordService.getAll(userId, bookId);
    }

    @PostMapping("/delete")
    public CommonResponseObject delete(@RequestBody DeleteWordRequest deleteWordRequest) {
        String token = deleteWordRequest.getToken();

        DecodedJWT decodedJWT = JwtUtils.verify(token);
        if (decodedJWT == null) {
            return new CommonResponseObject(1000, "not authenticated");
        }

        int userId = JwtUtils.getUserId(decodedJWT);

        int wordId = deleteWordRequest.getId();

        return wordService.delete(userId, wordId);
    }
}
