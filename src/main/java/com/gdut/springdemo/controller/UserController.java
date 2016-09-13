package com.gdut.springdemo.controller;

import com.gdut.springdemo.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jun on 2016/9/9.
 */
@Controller
public class UserController {

    Logger log = Logger.getLogger(UserController.class);

    @RequestMapping("/runtest")
    public String runtest(){
        return "Test";
    }

    @RequestMapping(value = "/test")
    public String objecttest(@Validated User user, BindingResult bindingResult, Model model){
        //// TODO: 2016/9/11 形参BindingResult要跟在实体类后面，否则报404错误
        model.addAttribute("user", user);

        /*UserValidator userValidator = new UserValidator();
        userValidator.validate(user, bindingResult);*/

        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            log.info("Code: " + fieldError.getCode() + ", field: " + fieldError.getField() + fieldError.getDefaultMessage());
            return "redirect:/runtest";
        }
        return "TestShow";
    }

    /*@RequestMapping(value = "date")
    @ResponseBody
    public String date1(Date date1){
        return date1.toString();
    }*/


    /*@InitBinder()
    public void initDate1(WebDataBinder binder){
        //binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
        binder.setValidator(new UserValidator());
        log.info("validator.........");
        binder.validate();
    }*/
}
