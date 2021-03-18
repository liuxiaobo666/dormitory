package com.sanxiau.dormitory.liu.service;

import com.github.pagehelper.PageInfo;
import com.sanxiau.dormitory.liu.entity.Dorsanit;

public interface DorsanitService {
    //查询全部卫生
    PageInfo<Dorsanit> findByHouId(int pageNum, int pageSize,String houId);
}
