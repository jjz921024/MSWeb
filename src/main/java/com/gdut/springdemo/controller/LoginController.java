package com.gdut.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Jun on 2016/9/20.
 */
@Controller
@RequestMapping(value = "/auth")
public class LoginController {

    @RequestMapping(value = "/login")
    public String getLoginPage(Model model, @RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout){

        if(error != null){
            model.addAttribute("error", "用户名或密码不正确!");
        }
        if(logout != null){
            model.addAttribute("logout", "您已注销登出！");
        }
        return "loginpage";
    }

    /*@RequestMapping(value = "/logout")
    public String getLogoutPage(Model model){
        model.addAttribute("logout", "您已成功注销系统.");
        return "../j_spring_security_logout";
    }*/

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String getDenedPage(){
        return "deniedpage";
    }


}
