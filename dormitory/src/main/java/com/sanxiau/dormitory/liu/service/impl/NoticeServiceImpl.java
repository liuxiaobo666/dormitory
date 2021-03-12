package com.sanxiau.dormitory.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanxiau.dormitory.liu.dao.NoticeDao;
import com.sanxiau.dormitory.liu.entity.Notice;
import com.sanxiau.dormitory.liu.mapper.NoticeMapper;
import com.sanxiau.dormitory.liu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public PageInfo<Notice> findByDesc(int pageNum, int pageSize) {
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Notice> notices = new ArrayList<>();
        notices = noticeMapper.findByDesc();
        PageInfo pageInfo = new PageInfo(notices);
        return pageInfo;
    }
}
