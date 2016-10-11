package com.gdut.springdemo.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Jun on 2016/9/12.
 */
@Component("DBAccess")
public class DBAccess {

    public SqlSession getSqlSession() throws IOException{

        //通过配置文件获取数据库连接信息
        //测试时路径  "resources/mybatis/Configuration.xml" 或者把/去掉
        //   /mybatis/Configuration.xml
        Reader reader = Resources.getResourceAsReader("resources/mybatis/Configuration.xml");

        //通过配置信息构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //通过SqlSessionFactory打开一个数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
