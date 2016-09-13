package com.gdut.springdemo.controller;

import com.gdut.springdemo.model.Book;
import com.gdut.springdemo.service.BookService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public class BookController {

    Logger log = Logger.getLogger(BookController.class);
    private static Log logger = LogFactory.getLog(BookController.class);

    @Resource(name = "BookServiceDatabase")
    private BookService bookService;

    /*
        书籍列表  入口
    * */
    @RequestMapping(value = "/book_list")
    public String listBook(Model model){
        List<Book> books = bookService.getAllBooks();
        if(books != null){
            model.addAttribute("books", books);
        }
        return "BookList";
    }

    /*
    *   录入书籍  跳转到录入界面
    * */
    @RequestMapping(value = "/book_input")
    public String inputBook(){
        return "BookAdd";
    }

    /*
    *   保存书籍信息
    *   参数：与表单绑定的book对象
    * */
    @RequestMapping(value = "/book_save", method = RequestMethod.POST)
    public String saveBook(@Valid Book book, BindingResult bindingResult, Model model) throws IOException {
        model.addAttribute("book", book);

        //验证信息
        if(bindingResult.hasErrors()){
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for(FieldError error : errorList){
                log.info(error.getDefaultMessage());
            }
            return "redirect:/book_input";
        }

        //保存图片路径
        if(!book.getImg().isEmpty()){
            //System.getProperty("SpringDemo.root")
            String imgPath ="D:/javaworkspace/SpringDemo/src/main/webapp/resources/img/" + System.currentTimeMillis() + book.getImg().getOriginalFilename();
            //保存图片路径
            book.setImgPath(imgPath);
            //保存图片到文件系统
            FileUtils.copyInputStreamToFile(book.getImg().getInputStream(), new File(imgPath));
        }
        bookService.add(book);
        return "redirect:/book_list";
    }

    /*
    *   删除书籍
    *   参数：书籍id  Restful风格
    * */
    @RequestMapping(value = "/book_delete/{id}")
    public String deleteBook(@PathVariable int id){
        Book book = bookService.getBookByID(id);

        //先判断路径是否为空
        if(book.getImgPath() != null && !"".equals(book.getImgPath())){
            File imgFile = new File(book.getImgPath());
            if(imgFile.exists() && imgFile.isFile()){
                imgFile.delete();
            }
        }
        bookService.deleteBookByID(id);
        return "redirect:/book_list";
    }

    /*
    *   编辑书籍跳转url
    *   参数：书籍id     通过id获取book对象，保存进model
    *   返回：书籍编辑页面
    * */
    @RequestMapping(value = "/book_edit/{id}")
    public String editBook(@PathVariable int id, Model model){
        model.addAttribute("book", bookService.getBookByID(id));
        return "BookEdit";
    }

    /*
    *   更新保存书籍信息
    *   参数：书籍id      表单上没有书籍id字段,新的book上id属性为0
    *
    * */
    @RequestMapping(value = "/book_update/{id}")
    public String updateBook(@PathVariable int id, Book book) throws IOException {
        book.setId(id);

        //删除原有图片
        Book oldbook = bookService.getBookByID(id);
        File imgFile = new File(oldbook.getImgPath());
        if(imgFile.exists() && imgFile.isFile()){
            imgFile.delete();
        }

        //改变图片路径并上传新图片
        if(!book.getImg().isEmpty()){
            //System.getProperty("SpringDemo.root")
            String imgPath ="D:/javaworkspace/SpringDemo/src/main/webapp/resources/img/" + System.currentTimeMillis() + book.getImg().getOriginalFilename();
            //保存图片路径
            book.setImgPath(imgPath);
            //保存图片到文件系统
            FileUtils.copyInputStreamToFile(book.getImg().getInputStream(), new File(imgPath));
        }
        bookService.update(book);
        return "redirect:/book_list";
    }
}
