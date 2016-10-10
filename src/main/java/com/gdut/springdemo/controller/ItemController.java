package com.gdut.springdemo.controller;

import com.gdut.springdemo.model.Item;
import com.gdut.springdemo.dao.ItemDao;
import com.gdut.springdemo.model.ItemForm;
import com.gdut.springdemo.model.ListForm;
import com.gdut.springdemo.service.ItemService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by Jun on 2016/9/5.
 */
@Controller
@RequestMapping(value = "/item")
public class ItemController {

    Logger log = Logger.getLogger(ItemController.class);

    @Resource(name = "itemService")
    private ItemService itemService;

    /*
        商品列表  入口
    * */
    @RequestMapping(value = "/list")
    public String listItem(Model model){
        List<ListForm> listForms = itemService.listForms();
        if(listForms != null){
            model.addAttribute("listForms", listForms);
        }
        return "ItemList";
    }

    /*
    *   录入商品  跳转到录入界面
    * */
    @RequestMapping(value = "/input")
    public String inputItem(){
        return "ItemAdd";
    }

    /*
    *   保存商品信息
    *   参数：与表单绑定的book对象
    * */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveItem(@Valid ItemForm itemForm, BindingResult bindingResult, Model model) throws IOException {

        //验证信息
        if(bindingResult.hasErrors()){
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for(FieldError error : errorList){
                log.info(error.getDefaultMessage());
            }
            return "redirect:/item/input";
        }

        //保存图片路径
        /*if(!item.getImg().isEmpty()){
            //System.getProperty("SpringDemo.root")
            String imgPath ="D:/javaworkspace/SpringDemo/src/main/webapp/resources/img/" + System.currentTimeMillis() + item.getImg().getOriginalFilename();
            //保存图片路径
            item.setImgPath(imgPath);
            //保存图片到文件系统
            FileUtils.copyInputStreamToFile(item.getImg().getInputStream(), new File(imgPath));
        }*/
        itemService.addItem(itemForm);
        return "redirect:/item/list";
    }

    /*
    *   删除商品
    *   参数：商品id  Restful风格
    * */
    @RequestMapping(value = "/delete/{id}")
    public String deleteItem(@PathVariable int id){
        //Item item = itemService.getItemByID(id);

        //先判断路径是否为空
        /*if(item.getImgPath() != null && !"".equals(item.getImgPath())){
            File imgFile = new File(item.getImgPath());
            if(imgFile.exists() && imgFile.isFile()){
                imgFile.delete();
            }
        }*/
        itemService.deleteItemByID(id);
        return "redirect:/item/list";
    }

    /*
    *   编辑商品跳转url
    *   参数：商品id     通过id获取book对象，保存进model
    *   返回：商品编辑页面
    * */
    @RequestMapping(value = "/edit/{id}")
    public String editItem(@PathVariable int id, Model model){
        model.addAttribute("itemForm", itemService.getItemForm(id));
        return "ItemEdit";
    }

    /*
    *   更新保存商品信息
    *   参数：商品id      表单上没有商品id字段,新的book上id属性为0
    *
    * */
    @RequestMapping(value = "/update/{id}")
    public String updateItem(@PathVariable int id, ItemForm itemForm) throws IOException {
        itemForm.setItemID(id);
        itemService.updateItemForm(itemForm);
        return "redirect:/item/list";
    }
}
