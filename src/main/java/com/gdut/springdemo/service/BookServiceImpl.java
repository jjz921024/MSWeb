package com.gdut.springdemo.service;

import com.gdut.springdemo.model.Book;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * Created by Jun on 2016/9/5.
 */
@Service("BookService")
public class BookServiceImpl implements BookService{

    private List<Book> books = new ArrayList<Book>();

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public boolean add(Book book) {
        book.setId(books.size());
        books.add(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        Book updateBook = getBookByID(book.getId());

        updateBook.setName(book.getName());
        updateBook.setPrice(book.getPrice());
        updateBook.setDescription(book.getDescription());
        return true;
    }

    @Override
    public Book getBookByID(int id) {
        for(Book book :books){
            if(book.getId() == id)
                return book;
        }
        return null;
    }

    @Override
    public Book deleteBookByID(int id) {
        return  books.remove(books.indexOf(getBookByID(id)));
    }

    public BookServiceImpl(){
        /*String date = sdf.format(Calendar.getInstance().getTime());*/
        books.add(new Book(0, "C++", 9.2f, "C++"));
        books.add(new Book(1, "JAVA", 13.2f, "JAVA"));
    }
}
