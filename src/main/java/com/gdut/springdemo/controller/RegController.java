package com.gdut.springdemo.controller;

import com.gdut.springdemo.model.CustomUser;
import com.gdut.springdemo.service.RegUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by Jun on 2016/10/9.
 */
@Controller
@RequestMapping(value = "/reg")
public class RegController {

    @Resource
    private RegUserService regUserService;

    @RequestMapping(value = "/input")
    public String getRegPage(Model model, @RequestParam(value = "success", required = false) String success){
        if("true".equals(success)){
            model.addAttribute("regmessage", "注册成功");
        } else if ("false".equals(success)){
            model.addAttribute("regmessage", "注册失败");
        }
        return "regpage";
    }

    /*
    *   注册一个新用户
    * */
    //// TODO: 2016/10/9 表单验证没做
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String regSubmit(CustomUser user){
        int result = regUserService.regUser(user);
        if(result != -1 && result != 0){
            return "redirect:/reg/input?success=true";
        }else {
            return "redirect:/reg/input?success=false";
        }
    }
}
