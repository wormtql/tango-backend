package com.example.tango.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.tango.dto.CommonResponseObject;
import com.example.tango.dto.CreateWordRequest;
import com.example.tango.service.WordService;
import com.example.tango.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/word")
public class WordController {
    private WordService wordService;

    @Autowired
    public WordController(@RequestBody WordService wordService) {
        this.wordService = wordService;
    }

    @PostMapping("/create")
    public CommonResponseObject create(@RequestBody CreateWordRequest createWordRequest) {
        String token = createWordRequest.getToken();

        DecodedJWT decodedJWT = JwtUtils.verify(token);
        if (decodedJWT == null) {
            return new CommonResponseObject(1000, "not authenticated");
        }

        int userId = JwtUtils.getUserId(decodedJWT);

        int bookId = createWordRequest.getBookId();
        String s1 = createWordRequest.getS1();
        String s2 = createWordRequest.getS2();
        String attr = createWordRequest.getAttribute();
        String pro = createWordRequest.getPronunciation();

        return wordService.create(userId, bookId, s1, s2, attr, pro);
    }
}
