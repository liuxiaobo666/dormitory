package com.sanxiau.dormitory.liu.controller;

import com.sanxiau.dormitory.liu.dao.*;
import com.sanxiau.dormitory.liu.entity.House;
import com.sanxiau.dormitory.liu.entity.Riches;
import com.sanxiau.dormitory.liu.entity.Student;
import com.sanxiau.dormitory.liu.entity.User;
import com.sanxiau.dormitory.liu.mapper.DormMapper;
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
@RequestMapping("/student")
public class StudentController {

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

    //查看所有学生信息
    @RequestMapping("/students")
    public String allStudent(Model model) {
        List<Student> students = new ArrayList<>();
        try {

            //查询全部学生
            students = studentDao.findAll();
            model.addAttribute("students", students);

        } catch (Exception e) {
            //错误处理
            return "liu/error";
        }
        return "liu/student";
    }

    //去增加页面
    @RequestMapping("/goAddStudent")
    public String goAddStudent(Model model) {
        List<House> houses = new ArrayList<>();
        houses =  houseDao.findAll();
        model.addAttribute("houses", houses);
        return "liu/addStudent";
    }




    //增加学生
    @PostMapping("/addStudent")
    public String addStudent(Student student) {
        try {
            //增加学生所住寝室信息
            Riches riches = new Riches();
            riches.setHouId(student.getHouId());
            riches.setDorId(student.getDorId());
            riches.setStuName(student.getStuName());
            riches.setStuId(student.getStuId());
            richesDao.save(riches);
            //增加学生
            student.setStuSta("在校");
            studentDao.save(student);
                return "liu/success";
        } catch (Exception e) {
            return "liu/error";
        }

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
