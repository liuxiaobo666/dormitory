package com.sanxiau.dormitory.liu.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 可以使用jpa注解或者mapper映射文件，这里我选的是mapper
 */
@Mapper
public interface TestMapper {

    //查询所有
    List<Map> findAll();
}