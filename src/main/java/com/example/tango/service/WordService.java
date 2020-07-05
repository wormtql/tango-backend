package com.example.tango.service;

import com.example.tango.Model.Book;
import com.example.tango.Model.Word;
import com.example.tango.dto.AllWordResponse;
import com.example.tango.dto.CommonResponseObject;
import com.example.tango.dto.CreateWordResponse;
import com.example.tango.mapper.BookMapper;
import com.example.tango.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WordService {
    private WordMapper wordMapper;
    private BookMapper bookMapper;

    @Autowired
    public WordService(WordMapper wordMapper, BookMapper bookMapper) {
        this.wordMapper = wordMapper;
        this.bookMapper = bookMapper;
    }

    public CreateWordResponse create(int userId, int bookId, String s1, String s2, String attr, String pro) {
        Book book = bookMapper.selectBookByIdAndUserId(bookId, userId);

        if (book == null) {
            return new CreateWordResponse("book not exist", 1000, null);
        }

        Word word = new Word(s1, s2, attr, pro, bookId, userId, 0);
//        int id = wordMapper.insertWord(s1, s2, attr, pro, bookId);
//        Word word = wordMapper.selectById(id);
        wordMapper.insertWord(word);
        return new CreateWordResponse("ok", 200, word);
    }

    public AllWordResponse getAll(int userId, int bookId) {
        Book book = bookMapper.selectBookByIdAndUserId(bookId, userId);

        if (book == null) {
            return new AllWordResponse("book not exist", 1000, null);
        }

        ArrayList<Word> words = wordMapper.selectByBookId(bookId);
        return new AllWordResponse("ok", 200, words);
    }

    public CommonResponseObject delete(int userId, int wordId) {
        Word word = wordMapper.selectByIdAndUserId(wordId, userId);
        if (word == null) {
            return new CommonResponseObject(1000, "word not exist");
        }

        wordMapper.deleteWord(wordId, userId);
        return new CommonResponseObject(200, "ok");
    }
}
