package com.sanxiau.dormitory.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sanxiau.dormitory.liu.entity.Dorsanit;
import com.sanxiau.dormitory.liu.entity.Notice;
import com.sanxiau.dormitory.liu.mapper.DorsanitMapper;
import com.sanxiau.dormitory.liu.mapper.NoticeMapper;
import com.sanxiau.dormitory.liu.service.DorsanitService;
import com.sanxiau.dormitory.liu.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DorsanitServiceImpl implements DorsanitService {

    @Autowired
    DorsanitMapper dorsanitMapper;

    @Override
    public PageInfo<Dorsanit> findByHouId(int pageNum, int pageSize,String houId) {
        //分页
        PageHelper.startPage(pageNum,pageSize);
        List<Dorsanit> dorsanits = new ArrayList<>();
        dorsanits = dorsanitMapper.findByHouId(houId);
        PageInfo pageInfo = new PageInfo(dorsanits);
        return pageInfo;
    }
}
