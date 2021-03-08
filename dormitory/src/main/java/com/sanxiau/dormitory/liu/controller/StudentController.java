package com.sanxiau.dormitory.liu.controller;

import com.sanxiau.dormitory.liu.dao.*;
import com.sanxiau.dormitory.liu.entity.*;
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
        List<House> houses = new ArrayList<>();
        try {

            //查询全部学生
            students = studentDao.findAll();
            //查询全部宿舍楼
            houses = houseDao.findAll();
            model.addAttribute("students", students);
            model.addAttribute("houses", houses);

        } catch (Exception e) {
            //错误处理
            return "liu/error";
        }
        return "liu/student";
    }


    //根据id查询学生
    @ResponseBody
    @GetMapping("/findOneStudent")
    public List<Student> findOneStudent(int id, HttpServletRequest request) {
        System.out.println("....." + id);
        List<Student> student = new ArrayList<>();
        student = studentDao.findById1(id);
        //把宿舍号存入session
        request.getSession().setAttribute("StudentDorId", student.get(0).getDorId());
        return student;
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

    //修改学生信息
    @PostMapping("/studentUpdate")
    public String studentUpdate(Student student, HttpServletRequest request) {
        System.out.println("学生" + student);
        try {
            //得到学生的状态
            String stuSta = student.getStuSta();
            if (stuSta.equals("永久离校")){
                //删除学生在宿舍的信息
                richesDao.deleteRichesByStuId(student.getStuId());
                //修改学生信息
                studentDao.studentUpdate(student.getId(),student.getIdCard(),student.getHouId(),student.getDorId(),student.getStuStudy(),student.getStuClass(),student.getStuCname(),student.getStuPolit(),student.getStuAdd(),student.getEmail(),student.getStuTel(),student.getStuSta(),student.getStuDes());
                return "redirect:/student/students";
            }else {
                //修改学生财产信息
                richesDao.richesUpdateByStuId(student.getStuId(),student.getHouId(),student.getDorId());
                //修改学生信息
                studentDao.studentUpdate(student.getId(),student.getIdCard(),student.getHouId(),student.getDorId(),student.getStuStudy(),student.getStuClass(),student.getStuCname(),student.getStuPolit(),student.getStuAdd(),student.getEmail(),student.getStuTel(),student.getStuSta(),student.getStuDes());
                return "redirect:/student/students";
            }

        } catch (Exception e) {
            return "liu/error";
        }
    }

}
