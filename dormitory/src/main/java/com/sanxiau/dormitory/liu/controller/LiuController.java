package com.sanxiau.dormitory.liu.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


//页面跳转
@Controller
@RequestMapping("/liu")
public class LiuController {

    //错误页面
    @RequestMapping("/error")
    public String error() {
      return "liu/error";
    }

    //成功页面
    @RequestMapping("/success")
    public String success() {
        return "liu/success";
    }
}
