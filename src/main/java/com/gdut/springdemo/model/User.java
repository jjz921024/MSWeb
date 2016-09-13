package com.gdut.springdemo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;



/**
 * Created by Jun on 2016/9/9.
 */
public class User {

    @Size(max = 5, min = 2)
    private String username;

    @NotEmpty(message = "hahahaha...")
    private String password;
    //private int level;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }*/
}
