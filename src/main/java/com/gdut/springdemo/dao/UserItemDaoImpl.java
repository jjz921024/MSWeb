package com.gdut.springdemo.dao;

import com.gdut.springdemo.db.DBAccess;
import com.gdut.springdemo.model.UserItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by Jun on 2016/10/9.
 */
@Repository("userItemDaoImpl")
public class UserItemDaoImpl implements UserItemDao {

    @Resource(name = "DBAccess")
    private DBAccess dbAccess;

    @Override
    public int addUserItem(UserItem userItem) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("addUserItem", userItem);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return userItem.getId();
    }

    @Override
    public UserItem deleteUserItem(UserItem userItem) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("deleteUserItemByTwoID", userItem);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        //暂时先返回这
        return userItem;
    }

    @Override
    public UserItem getUserItemByItemID(int itemID) {
        SqlSession sqlSession = null;
        UserItem userItem = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            userItem = sqlSession.selectOne("getUserItemByItemID",itemID);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return userItem;
    }

    @Override
    public boolean updateUserItem(UserItem userItem) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.update("updateUserItem", userItem);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return true;
    }
}
