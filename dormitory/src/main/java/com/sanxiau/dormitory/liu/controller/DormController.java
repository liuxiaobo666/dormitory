package com.sanxiau.dormitory.liu.controller;

import com.sanxiau.dormitory.liu.dao.DormDao;
import com.sanxiau.dormitory.liu.dao.HouseDao;
import com.sanxiau.dormitory.liu.dao.UserDao;
import com.sanxiau.dormitory.liu.entity.Dorm;
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
 * 寝室控制层
 */
@Controller
@RequestMapping("/dorm")
public class DormController {

    @Autowired
    HouseDao houseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    DormDao dormDao;


    //查看所有寝室信息
    @RequestMapping("/dorms")
    public String allDorm(Model model) {
        List<Dorm> dorms = new ArrayList<>();
        try {
            dorms = dormDao.findAll();
            model.addAttribute("dorms", dorms);
        } catch (Exception e) {
            //错误处理
            return "liu/error";
        }
        return "liu/dorm";
    }

    //根据id查询寝室
    @ResponseBody
    @GetMapping("/findOneDorm")
    public List<Dorm> findOneDorm(int id, HttpServletRequest request) {
        System.out.println("....." + id);
        List<Dorm> dorm = new ArrayList<>();
        dorm = dormDao.findById(id);
        //把宿舍号存入session
        request.getSession().setAttribute("dorId", dorm.get(0).getDorId());
        return dorm;
    }

    //修改寝室信息
    @PostMapping("/dormUpdate")
    public String dormUpdate(Dorm dorm, HttpServletRequest request) {
        System.out.println("寝室" + dorm);
        //寝室号
        String dorId = dorm.getDorId();
        String OldDorId = request.getSession().getAttribute("dorId").toString();
        System.out.println("session...." + OldDorId);
        try {
            if (OldDorId.equals(dorId)) {
                //调用更改寝室业务
                dormDao.dormUpdate(dorm.getId(), dorm.getDorId(), dorm.getDorIex(), dorm.getDorNum(), dorm.getDorPrice(), dorm.getTel(), dorm.getDorDes());
                return "redirect:/dorm/dorms";
            } else {
                //判断是否已经存在寝室编号
                List<Dorm> dorm1 = dormDao.findByHouIdAndDorId(dorm.getHouId(), dorm.getDorId());
                if (null == dorm1 || dorm1.isEmpty()) {
                    //调用更改寝室业务
                    dormDao.dormUpdate(dorm.getId(), dorm.getDorId(), dorm.getDorIex(), dorm.getDorNum(), dorm.getDorPrice(), dorm.getTel(), dorm.getDorDes());
                    return "redirect:/dorm/dorms";
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
