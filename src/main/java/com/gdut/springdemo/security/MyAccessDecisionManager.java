package com.gdut.springdemo.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Jun on 2016/9/23.
 */
public class MyAccessDecisionManager implements AccessDecisionManager {

    /*  最重要的是decide方法，如果不存在对该资源的定义，直接放行；否则，
        如果找到正确的角色，即认为拥有权限，并放行，否则throw new AccessDeniedException("no right");
        这样，就会进入上面提到的403.jsp页面。*/

    /*   比较authentication和configAttributes
        1、object 是一个URL，在过滤器中通过这个url找到允许的配置，则放行
        2、检查authentication拥有的attribute在允许的配置里
        3、如果没有相匹配的权限，抛出异常 */
    // 2, Check authentication has attribute in permission configuration (configAttributes)

    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if(configAttributes == null){
            return ;
        }

        System.out.println(object.toString());  //object is a URL.

        //"ROLE_XXX"
        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while(ite.hasNext()){
            ConfigAttribute ca = ite.next();
            String needRole = ((SecurityConfig)ca).getAttribute();
            for(GrantedAuthority ga : authentication.getAuthorities()){
                if(needRole.equals(ga.getAuthority())){  //ga is user's role.
                    return;
                }
            }
        }
        throw new AccessDeniedException("no right");
    }

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
}