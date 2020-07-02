package com.example.tango.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface WordMapper {
    @Insert("insert into word (s1, s2, attribute, pronunciation, book_id) values ('${s1}', '${s2}', '${attr}', '${pro}', ${bookId})")
    void insertWord(String s1, String s2, String attr, String pro, int bookId);
}
