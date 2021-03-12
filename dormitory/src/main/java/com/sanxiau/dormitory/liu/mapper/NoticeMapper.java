package com.sanxiau.dormitory.liu.mapper;


import com.sanxiau.dormitory.liu.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 可以使用jpa注解或者mapper映射文件，这里我选的是mapper
 */
@Mapper
public interface NoticeMapper {

    //查询全部数据
    List<Notice> findByDesc();


}
