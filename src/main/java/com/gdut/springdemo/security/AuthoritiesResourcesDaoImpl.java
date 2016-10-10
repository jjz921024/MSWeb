package com.gdut.springdemo.security;

import com.gdut.springdemo.db.DBAccess;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by Jun on 2016/9/28.
 */
@Repository("AuthoritiesResourcesDao")
public class AuthoritiesResourcesDaoImpl implements AuthoritiesResourcesDao {

    @Resource(name = "DBAccess")
    private DBAccess dbAccess;

    @Override
    public List<String> getAllAuthname() {
        SqlSession sqlSession = null;
        List<String> authList = null;

        try {
            sqlSession = dbAccess.getSqlSession();
            authList = sqlSession.selectList("getAllAuthname");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return authList;
    }

    @Override
    public List<String> getRespathByAuthname(String authname) {
        SqlSession sqlSession = null;
        List<String> respathList = null;

        try {
            sqlSession = dbAccess.getSqlSession();
            respathList = sqlSession.selectList("getRespathByAuthname",authname);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return respathList;
    }
}
