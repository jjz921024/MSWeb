package com.gdut.springdemo.security;

import java.util.List;

/**
 * Created by Jun on 2016/9/28.
 */
public interface AuthoritiesResourcesDao {

    List<String> getAllAuthname();

    List<String> getRespathByAuthname(String authname);
}
