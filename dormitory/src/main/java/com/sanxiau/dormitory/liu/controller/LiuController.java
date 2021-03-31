package com.sanxiau.dormitory.liu.controller;



import com.sanxiau.dormitory.liu.dao.ElectricDao;
import com.sanxiau.dormitory.liu.dao.NoticeDao;
import com.sanxiau.dormitory.liu.entity.Electric;
import com.sanxiau.dormitory.liu.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


//页面跳转
@Controller
@RequestMapping("/liu")
public class LiuController {
    @Autowired
    NoticeDao noticeDao;

    @Autowired
    ElectricDao electricDao;

    //错误页面
    @RequestMapping("/error")
    public String error() {
      return "liu/error";
    }

    //成功页面
    @RequestMapping("/success")
    public String success() {
        return "liu/success";
    }

    //主页面
    @RequestMapping("/index")
    public String index(Model model){
        //10条公告
        List<Notice> notices = new ArrayList<>();
        notices = noticeDao.findTen();
        model.addAttribute("notices",notices);

        //消息
        List<Electric> news1 = new ArrayList<>();
        Electric news = new Electric();
            //根据寝室号查询电费消息
            //假数据
            String dorId = "102";
            news1 = electricDao.findByDorId(dorId);
            //如果没有需要缴费信息
            if (news1 == null || news1.isEmpty()){
                news.setId(1);
                news.setPayMonth("还未更新");
                news.setHouId("...");
                news.setDorId("...");
                news.setDegrees(0.00);
                news.setPrice(BigDecimal.valueOf(0.00));
                news.setAllPrice(BigDecimal.valueOf(0.00));
                news.setConductor("...");
                news.setPayState("...");
                model.addAttribute("news", news);
            }else {
                news = news1.get(0);
                model.addAttribute("news", news);
            }


        return "comm/index";
    }

}
