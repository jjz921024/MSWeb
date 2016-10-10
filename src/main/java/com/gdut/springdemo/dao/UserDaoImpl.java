package com.gdut.springdemo.dao;

import com.gdut.springdemo.db.DBAccess;
import com.gdut.springdemo.model.CustomUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jun on 2016/9/19.
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{

    Logger log = Logger.getLogger(UserDaoImpl.class);

    @Resource(name = "DBAccess")
    private DBAccess dbAccess;

    @Override
    public List<CustomUser> getAllUsers() {
        return null;
    }

    @Override
    public CustomUser getUserByID(int id) {
        SqlSession sqlSession = null;
        CustomUser user = null;

        try {
            sqlSession = dbAccess.getSqlSession();
            user = sqlSession.selectOne("getUserByID", id);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return user;
    }

    @Override
    public CustomUser getUserByName(String name) {
        SqlSession sqlSession = null;
        CustomUser user = null;

        try {
            sqlSession = dbAccess.getSqlSession();
            user = sqlSession.selectOne("getUserByName", name);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return user;
    }

    @Override
    public int addUser(CustomUser customUser) {
        SqlSession sqlSession = null;
        //int id = 0;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.insert("addUser", customUser);
            sqlSession.commit();
        } catch (IOException e) {
            log.info("添加商品失败！！");
            e.printStackTrace();
            return -1;
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return customUser.getId();
    }

    @Override
    public boolean updateUserByID(int id) {
        return false;
    }

    @Override
    public CustomUser deleteUserByID(int id) {
        SqlSession sqlSession = null;
        CustomUser customUser = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            customUser = getUserByID(id);
            sqlSession.delete("deleteUserByID", id);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return customUser;
    }

    @Override
    public CustomUser deleteUserByName(String name) {
        SqlSession sqlSession = null;
        CustomUser customUser = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            customUser = getUserByName(name);
            sqlSession.delete("deleteUserByName", name);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return customUser;
    }
}
