package com.gdut.springdemo.model;

import org.apache.ibatis.type.JdbcType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;



/**
 * Created by Jun on 2016/9/9.
 */
public class CustomUser {

    private int id;

    @Size(max = 5, min = 2, message = "用户名长度不符")
    private String name;

    @NotEmpty(message = "密码为空")
    private String password;

    private boolean isadmin;

    private boolean enabled;

    private String email;

    private String weibo;

    public CustomUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }
}
