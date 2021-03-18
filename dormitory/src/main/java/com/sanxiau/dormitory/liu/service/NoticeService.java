package com.sanxiau.dormitory.liu.service;

import com.github.pagehelper.PageInfo;
import com.sanxiau.dormitory.liu.entity.Notice;

public interface NoticeService {
    //查询全部公告
    PageInfo<Notice> findByDesc(int pageNum, int pageSize);
}
