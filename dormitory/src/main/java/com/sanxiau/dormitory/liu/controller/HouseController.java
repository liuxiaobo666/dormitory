package com.sanxiau.dormitory.liu.controller;
import com.sanxiau.dormitory.liu.dao.HouseDao;
import com.sanxiau.dormitory.liu.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 宿舍楼控制层
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseDao houseDao;


    //查看所有宿舍楼信息
    @RequestMapping("/houses")
    public String allHouse(Model model) {
        List<House> houses = new ArrayList<>();
        try {
            houses = houseDao.findAll();

        }catch (Exception e){
            //错误处理
            return "liu/error";
        }
        model.addAttribute("houses", houses);
        return "liu/house";
    }
}
