package com.gdut.springdemo.service;

import com.gdut.springdemo.dao.UserDao;
import com.gdut.springdemo.dao.UserDaoImpl;
import com.gdut.springdemo.model.CustomUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Jun on 2016/10/9.
 */
@Service("regUserService")
public class RegUserService {

    @Resource
    private UserDaoImpl userDao;

    public int regUser(CustomUser user){
        return userDao.addUser(user);
    }
}
