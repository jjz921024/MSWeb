package com.gdut.springdemo.model;


import org.apache.ibatis.type.JdbcType;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Jun on 2016/9/5.
 */
public class Item {

    private int id;

    @NotEmpty(message = "请输入url")
    private String url;

    private String productName;

    @Digits(integer = 5, fraction = 2, message = "请输入一个正确的价格")
    private float currentPrice;

    @Digits(integer = 5, fraction = 2, message = "请输入一个正确的价格")
    private float buttomPrice;

    @Past(message = "日期不符合")
    private Date createDate;

    private boolean enabled;
    //private MultipartFile img;

    public Item(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
