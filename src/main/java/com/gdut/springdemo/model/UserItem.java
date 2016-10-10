package com.gdut.springdemo.model;

/**
 * Created by Jun on 2016/10/9.
 */
public class UserItem {
    private int id;
    private int userID;
    private int itemID;
    private String itemName;
    private boolean emailNotice;
    private boolean weiboNotice;
    private boolean noticePriceEnabled;
    private float noticePrice;
    private boolean deltaPriceEnabled;
    private float deltaPrice;

    public UserItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public boolean isEmailNotice() {
        return emailNotice;
    }

    public void setEmailNotice(boolean emailNotice) {
        this.emailNotice = emailNotice;
    }

    public boolean isWeiboNotice() {
        return weiboNotice;
    }

    public void setWeiboNotice(boolean weiboNotice) {
        this.weiboNotice = weiboNotice;
    }

    public boolean isNoticePriceEnabled() {
        return noticePriceEnabled;
    }

    public void setNoticePriceEnabled(boolean noticePriceEnabled) {
        this.noticePriceEnabled = noticePriceEnabled;
    }

    public float getNoticePrice() {
        return noticePrice;
    }

    public void setNoticePrice(float noticePrice) {
        this.noticePrice = noticePrice;
    }

    public boolean isDeltaPriceEnabled() {
        return deltaPriceEnabled;
    }

    public void setDeltaPriceEnabled(boolean deltaPriceEnabled) {
        this.deltaPriceEnabled = deltaPriceEnabled;
    }

    public float getDeltaPrice() {
        return deltaPrice;
    }

    public void setDeltaPrice(float deltaPrice) {
        this.deltaPrice = deltaPrice;
    }
}
