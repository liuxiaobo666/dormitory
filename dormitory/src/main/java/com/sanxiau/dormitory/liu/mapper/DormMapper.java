package com.sanxiau.dormitory.liu.mapper;

import org.apache.ibatis.annotations.Mapper;



/**
 * 可以使用jpa注解或者mapper映射文件，这里我选的是mapper
 */
@Mapper
public interface DormMapper {

    //根据宿舍楼分组统计数量
    int updateByHouseCount();

    //根据宿舍分组统计入住数量
    int updateByDormCount();


}
