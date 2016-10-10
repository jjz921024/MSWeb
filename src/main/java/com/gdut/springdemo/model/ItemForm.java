package com.gdut.springdemo.model;

import java.util.List;

/**
 * Created by Jun on 2016/10/9.
 */
public class ItemForm {

    private int itemID;

    private String itemName;

    private String url;

    private List<String> notice;

    public ItemForm() {
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getNotice() {
        return notice;
    }

    public void setNotice(List<String> notice) {
        this.notice = notice;
    }
}
