package com.sanxiau.dormitory.liu.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanxiau.dormitory.liu.dao.NoticeDao;
import com.sanxiau.dormitory.liu.entity.Dorm;
import com.sanxiau.dormitory.liu.entity.Notice;
import com.sanxiau.dormitory.liu.entity.Riches;
import com.sanxiau.dormitory.liu.entity.Student;
import com.sanxiau.dormitory.liu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 公告控制
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeDao noticeDao;

    @Autowired
    NoticeService noticeService;

    //公告主页
    @RequestMapping("/goNotice")
    public String goNotice(Model model){
        return "liu/notice";
    }

    //公告主页a
    @RequestMapping("/goAddNotice")
    public String goAddNotice(Model model){
        return "liu/addNotice";
    }

    //查询全部公告
    @ResponseBody
    @PostMapping("/AllNotice")
    public PageInfo<Notice> AllNotice(int pageNum, int pageSize) {
        if(pageNum==-1){
            pageNum=1;
        }
        //分页
        return noticeService.findByDesc(pageNum,pageSize);
    }


    //根据id查询寝室
    @ResponseBody
    @GetMapping("/findOneNotice")
    public List<Notice> findOneNotice(int id) {
        System.out.println("....." + id);
        List<Notice> notices = new ArrayList<>();
        notices = noticeDao.findById1(id);
        return notices;
    }

    //增加学生
    @PostMapping("/addNotice")
    public String addNotice(Notice notice) {
        try {
            //得到当前时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(new Date());
            notice.setDate(date);
            noticeDao.save(notice);
            return "liu/success";
        } catch (Exception e) {
            return "liu/error";
        }

    }
}
