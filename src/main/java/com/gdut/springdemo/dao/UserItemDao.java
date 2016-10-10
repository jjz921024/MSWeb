package com.gdut.springdemo.dao;

import com.gdut.springdemo.model.UserItem;

/**
 * Created by Jun on 2016/10/9.
 */
public interface UserItemDao {
    int addUserItem(UserItem userItem);
    UserItem deleteUserItem(UserItem userItem);
    UserItem getUserItemByItemID(int itemID);
    boolean updateUserItem(UserItem userItem);
}
