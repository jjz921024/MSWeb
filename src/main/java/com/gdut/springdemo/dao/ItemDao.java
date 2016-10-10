package com.gdut.springdemo.dao;

import com.gdut.springdemo.model.Item;

import java.util.List;

/**
 * Created by Jun on 2016/9/5.
 */
public interface ItemDao {

    List<Item> getAllItems();
    int addItem(Item item);
    boolean updateItem(Item item);
    Item getItemByID(int id);
    Item deleteItemByID(int id);
}
