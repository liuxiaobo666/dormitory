package com.sanxiau.dormitory.liu.controller;

import com.sanxiau.dormitory.liu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    //测试查询
    @RequestMapping("/test")
    public String tests(Model model){

        List<Map> list = testService.findAll();
        model.addAttribute("test",list);
        return "liu/test";
    }
}
