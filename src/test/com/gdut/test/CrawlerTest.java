package com.gdut.test;

import com.gdut.springdemo.controller.CrawlerController;
import com.gdut.springdemo.crawler.MyCrawler;
import com.gdut.springdemo.dao.ItemDaoImpl;
import com.gdut.springdemo.model.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jun on 2016/9/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = { "classpath:springconfig/spring-bean.xml" })
/*@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = "classpath:springconfig/spring-bean.xml"),
        @ContextConfiguration(name = "child", locations = "classpath:springconfig/springmvc-config.xml")
})*/
public class CrawlerTest {

    @Autowired
    private ItemDaoImpl itemDao;

    @Test
    public void testUrl() throws Exception {
        List<Item> itemList = itemDao.getAllItems();
        List<String> urlList = new ArrayList<String>();

        for(Item item : itemList){
            urlList.add(item.getUrl());
        }

        CrawlerController crawlerController = new CrawlerController(urlList);
        crawlerController.controller.start(MyCrawler.class, 1);
    }
}
