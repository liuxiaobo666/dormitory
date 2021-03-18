package com.sanxiau.dormitory.liu.controller;


import com.github.pagehelper.PageInfo;
import com.sanxiau.dormitory.liu.dao.DorsanitDao;
import com.sanxiau.dormitory.liu.dao.NoticeDao;
import com.sanxiau.dormitory.liu.entity.Dorsanit;
import com.sanxiau.dormitory.liu.entity.Notice;
import com.sanxiau.dormitory.liu.service.DorsanitService;
import com.sanxiau.dormitory.liu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 寝室卫生控制
 */
@Controller
@RequestMapping("/dorsanit")
public class DorsanitController {

    @Autowired
    NoticeDao noticeDao;

    @Autowired
    DorsanitService dorsanitService;

    @Autowired
    DorsanitDao dorsanitDao;

    //学生看寝室卫生
    @RequestMapping("/goDorsanitToStudent")
    public String goDorsanitToStudent(Model model){
        //寝室楼编号
        List<Dorsanit> dorsanits = new ArrayList<>();
        String houId = "蓝雾苑1舍";
        dorsanits = dorsanitDao.findDorsanitByHouId(houId);
        model.addAttribute("dorsanits",dorsanits.get(0));
        return "liu/dorsanitToStudent";
    }

    //去卫生页面
    @RequestMapping("/goDorsanitByHouId")
    public String goDorsanitByHouId() {
        return "liu/dorsanitByHouId";
    }


    //去增加卫生页面
    @RequestMapping("/goAddDorsanit")
    public String goAddDorsanit() {
        return "liu/addDorsanit";
    }


    //查询以前卫生
    @ResponseBody
    @PostMapping("/DorsanitByHouId")
    public PageInfo<Dorsanit> DorsanitByHouId(int pageNum, int pageSize) {
        if(pageNum==-1){
            pageNum=1;
        }
        String houId = "蓝雾苑1舍";
        //分页
        return dorsanitService.findByHouId(pageNum,pageSize,houId);
    }


    //根据id查询卫生
    @ResponseBody
    @GetMapping("/findOneDorsanit")
    public List<Dorsanit> findOneDorsanit(int id) {
        System.out.println("....." + id);
        List<Dorsanit> dorsanits = new ArrayList<>();
        dorsanits = dorsanitDao.findById1(id);
        return dorsanits;
    }



    //增加卫生
    @PostMapping("/addDorsanit")
    public String addDorsanit(Dorsanit dorsanit) {
        try {
            //得到当前时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(new Date());
            dorsanit.setSanitDate(date);
            //宿舍楼号
            String houId = "蓝雾苑1舍";
            dorsanit.setHouId(houId);
            //值班人
            String watch = "涛哥";
            dorsanit.setWatch(watch);
            dorsanitDao.save(dorsanit);
            return "liu/success";
        } catch (Exception e) {
            return "liu/error";
        }

    }

}
