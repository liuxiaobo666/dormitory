package com.sanxiau.dormitory.liu.controller;

import com.sanxiau.dormitory.liu.dao.DormDao;
import com.sanxiau.dormitory.liu.dao.HouseDao;
import com.sanxiau.dormitory.liu.dao.UserDao;
import com.sanxiau.dormitory.liu.entity.*;
import com.sanxiau.dormitory.liu.mapper.DormMapper;
import com.sanxiau.dormitory.liu.mapper.RichesMapper;
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
import java.util.Map;

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

    @Autowired
    DormMapper dormMapper;


    //查看所有寝室信息
    @RequestMapping("/dorms")
    public String allDorm(Model model) {
        List<Dorm> dorms = new ArrayList<>();
        List<House> house = new ArrayList<>();
        try {
            //更新实住人数
            int a = dormMapper.updateByDormCount();
            System.out.println("更改：：："+a);
            dorms = dormDao.findAll();
            model.addAttribute("dorms", dorms);
            house = houseDao.findAll();
            model.addAttribute("house",house);
        } catch (Exception e) {
            e.printStackTrace();
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
        dorm = dormDao.findById1(id);
        //把宿舍号存入session
        request.getSession().setAttribute("dorId", dorm.get(0).getDorId());
        return dorm;
    }

    //根据寝室楼编号去查询有空余床位的寝室
    @ResponseBody
    @GetMapping("/findDormByHouId")
    public List<Dorm> findDormByHouId(String houId, HttpServletRequest request) {
        List<Dorm> dorm = new ArrayList<>();
        dorm = dormDao.findDormByHouId(houId);
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
                dormDao.dormUpdate(dorm.getId(), dorm.getDorId(), dorm.getDorIex(), dorm.getDorNum(),  dorm.getTel(),dorm.getRich(), dorm.getDorDes());
                return "redirect:/dorm/dorms";
            } else {
                //判断是否已经存在寝室编号
                List<Dorm> dorm1 = dormDao.findByHouIdAndDorId(dorm.getHouId(), dorm.getDorId());
                if (null == dorm1 || dorm1.isEmpty()) {
                    //调用更改寝室业务
                    dormDao.dormUpdate(dorm.getId(), dorm.getDorId(), dorm.getDorIex(), dorm.getDorNum(),  dorm.getTel(),dorm.getRich(), dorm.getDorDes());
                    return "redirect:/dorm/dorms";
                } else {
                    return "liu/error";
                }
            }
        } catch (Exception e) {
            return "liu/error";
        }

    }

    //增加寝室
    @PostMapping("/dormAdd")
    public String dormAdd(Dorm dorm) {
        try {
            //设置默认数0
            dorm.setDorPrice(0);
            dormDao.save(dorm);
        } catch (Exception e) {
            return "liu/error";
        }
        return "liu/success";
    }

    //删除寝室信息
    @RequestMapping("/deleteDorm")
    public String deleteDorm(String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                //删除宿舍信息
                dormDao.deleteDormById(Collections.singletonList(Integer.valueOf(strs[i])));
            } catch (Exception e) {
                return "liu/error";
            }
        }
        return "liu/success";
    }
}
