package com.sanxiau.dormitory.liu.controller;

import com.sanxiau.dormitory.liu.dao.DormDao;
import com.sanxiau.dormitory.liu.dao.HouseDao;
import com.sanxiau.dormitory.liu.dao.RichesDao;
import com.sanxiau.dormitory.liu.dao.UserDao;
import com.sanxiau.dormitory.liu.entity.Dorm;
import com.sanxiau.dormitory.liu.entity.House;
import com.sanxiau.dormitory.liu.entity.Riches;
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
 * 寝室财产控制层
 */
@Controller
@RequestMapping("/riches")
public class RichesController {

    @Autowired
    HouseDao houseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    DormDao dormDao;

    @Autowired
    RichesDao richesDao;


    //查看所有寝室财产信息
    @RequestMapping("/riches")
    public String allRiches(Model model) {
        List<Riches> riches = new ArrayList<>();
        try {
            riches = richesDao.findAll();
            model.addAttribute("riches", riches);
        } catch (Exception e) {
            //错误处理
            return "liu/error";
        }
        return "liu/riches";
    }

    //根据id查询寝室财产
    @ResponseBody
    @GetMapping("/findOneRiches")
    public List<Riches> findOneRiches(int id, HttpServletRequest request) {
        System.out.println("....." + id);
        List<Riches> riches = new ArrayList<>();
        riches = richesDao.findById(id);
        return riches;
    }

    //修改寝室财产信息
    @PostMapping("/richesUpdate")
    public String richesUpdate(Riches riches, HttpServletRequest request) {
        System.out.println("寝室财产" + riches);
        try {
            //修改寝室财产信息
            richesDao.richesUpdate(riches.getId(),riches.getBedId(),riches.getStoolId(),riches.getDeskId(),riches.getKeySend(),riches.getRicDes());

        } catch (Exception e) {
            return "liu/error";
        }
    return "liu/success";
    }



    //删除寝室财产信息
    @RequestMapping("/deleteRiches")
    public String deleteRiches(String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                //删除宿舍财产信息
                richesDao.deleteRichesById(Collections.singletonList(Integer.valueOf(strs[i])));
            } catch (Exception e) {
                return "liu/error";
            }
        }
        return "liu/success";
    }
}
