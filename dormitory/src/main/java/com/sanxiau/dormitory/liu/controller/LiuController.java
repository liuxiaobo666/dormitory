package com.sanxiau.dormitory.liu.controller;



import com.sanxiau.dormitory.liu.dao.ElectricDao;
import com.sanxiau.dormitory.liu.dao.NoticeDao;
import com.sanxiau.dormitory.liu.entity.Electric;
import com.sanxiau.dormitory.liu.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


//页面跳转
@Controller
@RequestMapping("/liu")
public class LiuController {
    @Autowired
    NoticeDao noticeDao;

    @Autowired
    ElectricDao electricDao;

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
