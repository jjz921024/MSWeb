package com.gdut.springdemo.service;

import com.gdut.springdemo.model.Book;

import java.util.List;

/**
 * Created by Jun on 2016/9/5.
 */
public interface BookService {

    List<Book> getAllBooks();
    boolean add(Book book);
    boolean update(Book book);
    Book getBookByID(int id);
    Book deleteBookByID(int id);
}
