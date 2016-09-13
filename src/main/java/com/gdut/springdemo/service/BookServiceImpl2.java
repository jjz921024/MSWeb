package com.gdut.springdemo.service;

import com.gdut.springdemo.db.DBAccess;
import com.gdut.springdemo.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jun on 2016/9/12.
 */
@Service("BookServiceDatabase")
public class BookServiceImpl2 implements BookService{

    Logger log = Logger.getLogger(BookServiceImpl2.class);

    @Resource(name = "DBAccess")
    private DBAccess dbAccess;

    @Override
    public List<Book> getAllBooks() {
        SqlSession sqlSession = null;
        List<Book> books = new ArrayList<Book>();
        try {
            sqlSession = dbAccess.getSqlSession();
            books = sqlSession.selectList("getAllBooks");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return books;
    }

    @Override
    public boolean add(Book book) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            int id = sqlSession.insert("add", book);
            sqlSession.commit();
            book.setId(id);
        } catch (IOException e) {
            log.info("添加书籍失败！！");
            e.printStackTrace();
            return false;
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return true;
    }

    @Override
    public boolean update(Book book) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.update("update", book);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return true;
    }

    @Override
    public Book getBookByID(int id) {
        SqlSession sqlSession = null;
        Book book = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            book = sqlSession.selectOne("getBookByID", id);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return book;
    }

    @Override
    public Book deleteBookByID(int id) {
        SqlSession sqlSession = null;
        Book book = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            book = getBookByID(id);
            sqlSession.delete("deleteBookByID", id);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return book;
    }
}
