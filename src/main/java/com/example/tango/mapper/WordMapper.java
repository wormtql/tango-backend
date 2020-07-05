package com.example.tango.mapper;

import com.example.tango.Model.Word;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface WordMapper {
    @Insert("insert into word (s1, s2, attribute, pronunciation, bookId, userId) values ('${s1}', '${s2}', '${attribute}', '${pronunciation}', ${bookId}, ${userId})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = int.class)
    int insertWord(Word word);

    @Select("select * from word where bookId=${bookId} order by id desc")
    ArrayList<Word> selectByBookId(int bookId);

    @Select("select * from word where id=${id} and userId=${userId}")
    Word selectByIdAndUserId(int id, int userId);

    @Delete("delete from word where id=${id} and userId=${userId}")
    void deleteWord(int id, int userId);
}
