package com.gdut.springdemo.dao;

import com.gdut.springdemo.model.CustomUser;

import java.util.List;

/**
 * Created by Jun on 2016/9/19.
 */
public interface UserDao {

    List<CustomUser> getAllUsers();
    CustomUser getUserByID(int id);
    CustomUser getUserByName(String name);
    int addUser(CustomUser customUser);
    boolean updateUserByID(int id);
    CustomUser deleteUserByID(int id);
    CustomUser deleteUserByName(String name);

}
