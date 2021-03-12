package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.Dorm;
import com.sanxiau.dormitory.liu.entity.Notice;
import com.sanxiau.dormitory.liu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * 公告
 */
@Repository
public interface NoticeDao extends JpaRepository<Notice, Object> {


    //查询最后10条数据
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SELECT * from (select * from notice order by id desc) a LIMIT 10")
    List<Notice> findTen();


    //更据id去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from notice where id=:id")
     List<Notice> findById1(@Param("id") Integer id);


}
