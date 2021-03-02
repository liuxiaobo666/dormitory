package com.sanxiau.dormitory.liu.controller;


import com.sanxiau.dormitory.liu.dao.UserDao;
import com.sanxiau.dormitory.liu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用户控制层
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;


}
