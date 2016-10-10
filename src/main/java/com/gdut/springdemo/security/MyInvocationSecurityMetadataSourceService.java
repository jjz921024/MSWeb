package com.gdut.springdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import java.util.*;

/**
 * Created by Jun on 2016/9/23.
 *
 * 提供某个资源对应的权限定义，即getAttributes方法返回的结果
 *      目前是使用AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配
 * 此类初始化时，应该取到所有资源及其对应角色的定义
 *
 */
//@Service("myInvocationSecurityMetadataSourceService")
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private AuthoritiesResourcesDaoImpl authoritiesResourcesDao;

    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;


    public MyInvocationSecurityMetadataSourceService() {
        loadResourceDefine();
    }

    private void loadResourceDefine() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
        //依据权限名查找所有权限  "ROLE_ADMIN"，"ROLE_USER"
        List<String> query = authoritiesResourcesDao.getAllAuthname();

        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();

        //query里是权限名
        for (String auth : query) {
            ConfigAttribute ca = new SecurityConfig(auth);// "ROLE_ADMIN"

            //查找资源路径  权限资源链接表的id 与 权限表/资源表的id相等
            List<String> query1 = authoritiesResourcesDao.getRespathByAuthname(auth);

            //query1里是资源路径名
            for (String res : query1) {
                //判断资源文件和权限的对应关系，如果已经存在，要进行增加
                //一个资源对应多个权限
                if (resourceMap.containsKey(res)) {
                    Collection<ConfigAttribute> value = resourceMap.get(res);
                    value.add(ca);
                    resourceMap.put(res, value);  // "log.jsp","role_user,role_admin"

                } else {
                    atts.add(ca);
                    resourceMap.put(res, atts);
                }
                resourceMap.put(res, atts);
            }
        }
    }

    //根据url查找所有可以访问该url的权限
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // guess object is a URL.
        String url = ((FilterInvocation) object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.pathMatchesUrl(url, resURL)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }

    /*public void setAuthoritiesResourcesDao(AuthoritiesResourcesDaoImpl authoritiesResourcesDao) {
        this.authoritiesResourcesDao = authoritiesResourcesDao;
    }*/

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}