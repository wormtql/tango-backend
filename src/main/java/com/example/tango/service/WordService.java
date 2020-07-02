package com.example.tango.service;

import com.example.tango.Model.Book;
import com.example.tango.dto.CommonResponseObject;
import com.example.tango.mapper.BookMapper;
import com.example.tango.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    private WordMapper wordMapper;
    private BookMapper bookMapper;

    @Autowired
    public WordService(WordMapper wordMapper, BookMapper bookMapper) {
        this.wordMapper = wordMapper;
        this.bookMapper = bookMapper;
    }

    public CommonResponseObject create(int userId, int bookId, String s1, String s2, String attr, String pro) {
        Book book = bookMapper.selectBookByIdAndUserId(bookId, userId);

        if (book == null) {
            return new CommonResponseObject(1000, "book not exist");
        }

        wordMapper.insertWord(s1, s2, attr, pro, bookId);
        return new CommonResponseObject(200, "ok");
    }
}
