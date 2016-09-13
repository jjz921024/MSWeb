package com.gdut.springdemo.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Jun on 2016/9/5.
 */
public class Book {

    private int id;

    @NotEmpty(message = "请输入书名")
    private String name;

    @NotNull(message = "请输入单价")
    @Digits(integer = 5, fraction = 2, message = "请输入一个正确的价格")
    private float price;

    @Past(message = "日期不符合")
    private Date publicationDate;

    private String description;

    private MultipartFile img;

    private String imgPath;

    public Book(){

    }

    public Book(int id, String name, float price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Book(int id, String name, float price, Date publicationDate, String description, String imgPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.publicationDate = publicationDate;
        this.description = description;
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
