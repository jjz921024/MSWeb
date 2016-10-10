package com.gdut.springdemo.security;

import com.gdut.springdemo.dao.UserDaoImpl;
import com.gdut.springdemo.model.CustomUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Jun on 2016/9/19.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Resource(name = "userDaoImpl")
    private UserDaoImpl userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        CustomUser user = userDao.getUserByName(s);
        UserDetails userDetails = new User(user.getName(), user.getPassword(), true, true, true, true, getAuthorities(user.isadmin()));

        return userDetails;
    }

    /*
    *   获取访问权限
    * */
    private Collection<GrantedAuthority> getAuthorities(boolean isadmin) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        if(isadmin){
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }
        return authList;
    }
}
