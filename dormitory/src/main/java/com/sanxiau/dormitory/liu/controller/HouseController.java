package com.sanxiau.dormitory.liu.controller;

import com.sanxiau.dormitory.liu.dao.HouseDao;
import com.sanxiau.dormitory.liu.dao.UserDao;
import com.sanxiau.dormitory.liu.entity.House;
import com.sanxiau.dormitory.liu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 宿舍楼控制层
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseDao houseDao;

    @Autowired
    UserDao userDao;


    //查看所有宿舍楼信息
    @RequestMapping("/houses")
    public String allHouse(Model model) {
        List<House> houses = new ArrayList<>();
        List<User> users = new ArrayList<>();
        try {
            houses = houseDao.findAll();
            model.addAttribute("houses", houses);
            //查询所有空闲的宿管用户
            users = userDao.findUserByState();
            model.addAttribute("users", users);
        } catch (Exception e) {
            //错误处理
            return "liu/error";
        }
        return "liu/house";
    }

    //根据id查询宿舍楼
    @ResponseBody
    @GetMapping("/findOneHouse")
    public List<House> findOneHouse(int id, HttpServletRequest request) {
        System.out.println("....." + id);
        List<House> house = new ArrayList<>();
        house = houseDao.findById(id);
        //把楼房号存入session
        request.getSession().setAttribute("houId", house.get(0).getHouId());
        return house;
    }

    //修改宿舍楼信息
    @PostMapping("/houseUpdate")
    public String houseUpdate(House house, HttpServletRequest request) {
        System.out.println("房子" + house);
        //判断宿舍楼号有没有重复
        String houId = house.getHouId();
        String OldHouId = request.getSession().getAttribute("houId").toString();
        System.out.println("session...." + OldHouId);
        try {
            if (OldHouId.equals(houId)) {
                //管理用户不为空修改用户状态
                if ("" != house.getUserName() && null != house.getUserName()) {
                    userDao.updateUserByUserName(house.getUserName(), "2");
                }
                //调用更改宿舍楼业务
                houseDao.houseUpdate(house.getId(), house.getHouId(), house.getHouAdd(), house.getHouNum(), house.getHouRom(), house.getHouPeo(), house.getHouFact(), house.getUserName(), house.getHouDes());
                return "redirect:/house/houses";
            } else {
                List<House> house1 = houseDao.findById(house.getId());
                if (null == house1 || house1.isEmpty()) {
                    //管理用户不为空修改用户状态
                    if ("" != house.getUserName() && null != house.getUserName()) {
                        userDao.updateUserByUserName(house.getUserName(), "2");
                    }
                    //调用更改宿舍楼业务
                    houseDao.houseUpdate(house.getId(), house.getHouId(), house.getHouAdd(), house.getHouNum(), house.getHouRom(), house.getHouPeo(), house.getHouFact(), house.getUserName(), house.getHouDes());
                    return "redirect:/house/houses";
                } else {
                    return "liu/error";
                }
            }
        } catch (Exception e) {
            return "liu/error";
        }

    }

    //增加宿舍楼
    @PostMapping("/houseAdd")
    public String houseAdd(House house) {
        try {
            //管理用户不为空修改用户状态
            if ("" != house.getUserName() && null != house.getUserName()) {
                userDao.updateUserByUserName(house.getUserName(), "2");
            }
            houseDao.save(house);
        } catch (Exception e) {
            return "liu/error";
        }
        return "liu/success";
    }

    //删除宿舍楼信息
    @RequestMapping("/deleteHouse")
    public String deleteHouse(String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                //把楼房已经有的宿管状态改变
                List<House> list = houseDao.findById(Integer.valueOf(strs[i]));
                userDao.updateUserByUserName(list.get(0).getUserName(), "1");
                //删除宿舍楼信息
                houseDao.deleteHouseById(Collections.singletonList(Integer.valueOf(strs[i])));
            } catch (Exception e) {
                return "liu/error";
            }
        }
        return "liu/success";
    }
}
