package com.gdut.springdemo.dao;

import com.gdut.springdemo.db.DBAccess;
import com.gdut.springdemo.model.Item;
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
@Service("itemServiceImpl")
public class ItemDaoImpl implements ItemDao {

    Logger log = Logger.getLogger(ItemDaoImpl.class);

    @Resource(name = "DBAccess")
    private DBAccess dbAccess;

    @Override
    public List<Item> getAllItems() {
        SqlSession sqlSession = null;
        List<Item> items = new ArrayList<Item>();
        try {
            sqlSession = dbAccess.getSqlSession();
            items = sqlSession.selectList("getAllItems");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return items;
    }

    @Override
    public int addItem(Item item) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            //insert数据库时，返回写入的条数，自增id映射到item的id属性中
            sqlSession.insert("addItem", item);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return item.getId();
    }

    @Override
    public boolean updateItem(Item item) {
        SqlSession sqlSession = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            sqlSession.update("updateItem", item);
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

    @Override
    public Item getItemByID(int id) {
        SqlSession sqlSession = null;
        Item item = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            item = sqlSession.selectOne("getItemByID", id);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return item;
    }

    @Override
    public Item deleteItemByID(int id) {
        SqlSession sqlSession = null;
        Item item = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            item = getItemByID(id);
            sqlSession.delete("deleteItemByID", id);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return item;
    }

}
