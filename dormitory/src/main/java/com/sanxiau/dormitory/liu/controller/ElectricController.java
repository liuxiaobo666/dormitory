package com.sanxiau.dormitory.liu.controller;


import com.sanxiau.dormitory.liu.dao.*;
import com.sanxiau.dormitory.liu.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 电费控制层
 */
@Controller
@RequestMapping("/electric")
public class ElectricController {


    @Autowired
    HouseDao houseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    DormDao dormDao;

    @Autowired
    RichesDao richesDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    ElectricDao electricDao;

    //查看所有电费信息
    @RequestMapping("/electrics")
    public String allElectric(Model model) {
        List<Electric> electrics = new ArrayList<>();
        try {
            //查询全部学生
            electrics = electricDao.findAll();
            model.addAttribute("electrics", electrics);

        } catch (Exception e) {
            //错误处理
            return "liu/error";
        }
        return "liu/electric";
    }


    //增加电费信息
    @PostMapping("/electricAdd")
    public String electricAdd(Electric electric) {
        try {
            //判断寝室是否存在
            List<Dorm> dorm = dormDao.findDormByDorId(electric.getDorId());
            if (null == dorm || dorm.isEmpty()){
                return "liu/error";
            }else {
                //判断该月份寝室电费是否已经添加
                List<Electric> electric1 = electricDao.findByDateAndDorId(electric.getDorId(),electric.getPayMonth());
                if (null == electric1 || electric1.isEmpty()){
                    //根据处理账户得到楼房号

                    //根据处理账户得到处理人

                    //处理账户


                    //计算总费用
                    Double du = electric.getDegrees();
                    BigDecimal a = electric.getPrice();
                    BigDecimal b = new BigDecimal(Double.toString(du));
                    //相乘
                    BigDecimal total = a.multiply(b);
                    //增加电费信息
                    electric.setAllPrice(total);
                    //缴费状态
                    electric.setPayState("未缴");
                    electricDao.save(electric);
                    return "liu/success";
                }else {
                    return "liu/error";
                }

            }
        } catch (Exception e) {
            return "liu/error";
        }

    }

    //根据id缴费
    @ResponseBody
    @GetMapping("/electricUpdate")
    public Integer electricUpdate(int id, HttpServletRequest request) {
        System.out.println("....." + id);
        List<Electric> electrics = electricDao.findById1(id);
        String state = electrics.get(0).getPayState();
        if (state.equals("未缴")){
            //得到当前时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = simpleDateFormat.format(new Date());
            electricDao.electricUpdateById(id,date,"已缴","线下");
            return 1;
        }else {
            return 0;
        }
    }


}
