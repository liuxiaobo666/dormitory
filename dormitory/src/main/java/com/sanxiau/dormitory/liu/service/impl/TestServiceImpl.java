package com.sanxiau.dormitory.liu.service.impl;

import com.sanxiau.dormitory.liu.dao.TestDao;
import com.sanxiau.dormitory.liu.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao dao;

    @Override
    public List<Map> findAll() {
        return dao.findAll();
    }
}
