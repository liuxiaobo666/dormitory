package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.Dorsanit;
import com.sanxiau.dormitory.liu.entity.Notice;
import com.sanxiau.dormitory.liu.entity.Riches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 寝室卫生
 */
@Repository
public interface DorsanitDao extends JpaRepository<Dorsanit, Object> {

    //根据寝室楼编号查询最后添加的1条数据
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SELECT * from (SELECT * from (select * from dorsanit order by id desc) a where hou_id =:houId) b LIMIT 1;")
    List<Dorsanit> findDorsanitByHouId(@Param("houId") String houId);

    //更据id去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from dorsanit where id=:id")
    List<Dorsanit> findById1(@Param("id") Integer id);
}
