package com.gdut.springdemo.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Jun on 2016/10/10.
 */
public class ListForm {

    private int itemID;
    private String url;
    private String itemName;
    private String productName;
    private float currentPrice;
    private float buttomPrice;
    private Date createDate;

    public ListForm() {
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getButtomPrice() {
        return buttomPrice;
    }

    public void setButtomPrice(float buttomPrice) {
        this.buttomPrice = buttomPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
