package com.sanxiau.dormitory.liu.mapper;


import com.sanxiau.dormitory.liu.entity.Dorsanit;
import com.sanxiau.dormitory.liu.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 卫生
 */
@Mapper
public interface DorsanitMapper {

    //查询全部数据
    List<Dorsanit> findByHouId(String houId);


}
