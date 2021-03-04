package com.sanxiau.dormitory.liu.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 可以使用jpa注解或者mapper映射文件，这里我选的是mapper
 */
@Mapper
public interface RichesMapper {



    //根据寝室号统计实住人数
    List<Map> findByDorId();
}
