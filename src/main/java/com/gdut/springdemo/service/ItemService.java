package com.gdut.springdemo.service;

import com.gdut.springdemo.dao.ItemDaoImpl;
import com.gdut.springdemo.dao.UserDaoImpl;
import com.gdut.springdemo.dao.UserItemDaoImpl;
import com.gdut.springdemo.model.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Jun on 2016/10/9.
 */
@Service("itemService")
public class ItemService {

    @Resource
    private ItemDaoImpl itemDao;
    @Resource
    private UserDaoImpl userDao;
    @Resource
    private UserItemDaoImpl userItemDao;

    public List<Item> getAllItems(){
        return itemDao.getAllItems();
    }

    public Item getItemByID(int id){
        return itemDao.getItemByID(id);
    }

    /**
     * 查询列表
     */
    public List<ListForm> listForms(){
        List<ListForm> listForms = new ArrayList<>();

        List<Item> items = itemDao.getAllItems();

        for(Item item : items){
            UserItem userItem = userItemDao.getUserItemByItemID(item.getId());
            ListForm listForm = new ListForm();
            listForm.setItemID(item.getId());
            listForm.setUrl(item.getUrl());
            listForm.setProductName(item.getProductName());
            listForm.setCreateDate(item.getCreateDate());
            listForm.setCurrentPrice(item.getCurrentPrice());
            listForm.setButtomPrice(item.getButtomPrice());
            listForm.setItemName(userItem.getItemName());
            listForms.add(listForm);
        }
        return listForms;
    }

    /**
    * 插入一个条目
    * */
    public boolean addItem(ItemForm itemForm){
        Item item = new Item();
        item.setUrl(itemForm.getUrl());
        item.setCreateDate(Calendar.getInstance().getTime());
        //写入Item表
        int itemID = itemDao.addItem(item);

        UserItem userItem = new UserItem();
        userItem.setItemName(itemForm.getItemName());

        List noticeList = itemForm.getNotice();
        if(noticeList != null){
            if(noticeList.contains("email")){
                userItem.setEmailNotice(true);
            }
            if(noticeList.contains("weibo")){
                userItem.setWeiboNotice(true);
            }
        }

        //获取写入商品的ID
        if(itemID != -1 && itemID != 0){
            userItem.setItemID(itemID);
        }
        //获取当前登录的用户信息
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser customUser = userDao.getUserByName(userDetails.getUsername());
        userItem.setUserID(customUser.getId());
        int userItemID = userItemDao.addUserItem(userItem);

        if(itemID != -1 && itemID != 0 && userItemID != -1 && userItemID != 0){
            return true;
        }
        return false;
    }

    /**
     *  删除一个条目
     *  获得userid和itemid   先删除useritem表再删除item表
     */
    public boolean deleteItemByID(int id){
        //获取当前用户id  customUser.getID()
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser customUser = userDao.getUserByName(userDetails.getUsername());

        UserItem userItem = new UserItem();
        userItem.setUserID(customUser.getId());
        userItem.setItemID(id);

        //删除useritem表的记录
        UserItem deleteresult = userItemDao.deleteUserItem(userItem);
        //删除item表的记录
        Item item = itemDao.deleteItemByID(id);
        if(deleteresult == null || item == null){
            return false;
        }
        return true;
    }

    public ItemForm getItemForm(int itemID){
        ItemForm itemForm = new ItemForm();

        Item item = itemDao.getItemByID(itemID);
        itemForm.setUrl(item.getUrl());
        itemForm.setItemID(itemID);

        UserItem userItem = userItemDao.getUserItemByItemID(itemID);
        itemForm.setItemName(userItem.getItemName());

        List<String> noticeList = new ArrayList<>();
        if(userItem.isEmailNotice()){
            noticeList.add("email");
        }
        if(userItem.isWeiboNotice()){
            noticeList.add("weibo");
        }
        itemForm.setNotice(noticeList);

        return itemForm;
    }

    public boolean updateItemForm(ItemForm itemForm){

        Item item = new Item();
        item.setUrl(itemForm.getUrl());
        item.setId(itemForm.getItemID());
        //写入Item表
        itemDao.updateItem(item);

        UserItem userItem = new UserItem();
        userItem.setItemName(itemForm.getItemName());
        userItem.setItemID(itemForm.getItemID());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser customUser = userDao.getUserByName(userDetails.getUsername());
        userItem.setUserID(customUser.getId());

        List noticeList = itemForm.getNotice();
        if(noticeList != null){
            if(noticeList.contains("email")){
                userItem.setEmailNotice(true);
            }
            if(noticeList.contains("weibo")){
                userItem.setWeiboNotice(true);
            }
        }
        userItemDao.updateUserItem(userItem);
        return true;
    }
}
