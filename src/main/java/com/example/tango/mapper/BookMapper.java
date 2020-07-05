package com.example.tango.mapper;

import com.example.tango.Model.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface BookMapper {
//    @Select("select * from book where id=${id}")
//    public Book selectBookById(int id);

    @Select("select * from book where name='${name}' and userId=${userId}")
    Book selectBookByNameAndUserId(String name, int userId);

    @Select("select * from book where id=${id} and userId=${userId}")
    Book selectBookByIdAndUserId(int id, int userId);

    @Insert("insert into book (name, description, star, fork, userId, isPublic) values ('${name}', '${des}', 0, 0, ${userId}, ${isPublic})")
    void insertBook(String name, String des, int userId, int isPublic);

    @Delete("delete from book where name='${name}' and userId=${userId}")
    void deleteByNameAndUserId(String name, int userId);

    @Select("select * from book where userId=${userId} order by id desc")
    ArrayList<Book> selectAllBooksByUserId(int userId);
}
