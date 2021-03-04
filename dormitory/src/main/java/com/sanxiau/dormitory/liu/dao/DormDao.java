package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.Dorm;
import com.sanxiau.dormitory.liu.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


/**
 * 宿舍楼
 */
@Repository
public interface DormDao extends JpaRepository<Dorm, Object> {


    //更据宿舍id去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from dorm where id=:id")
    List<Dorm> findById1(@Param("id") Integer id);


    //更据宿舍id去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from dorm where hou_id=:houId and dor_id=:dorId ")
    List<Dorm> findByHouIdAndDorId(@Param("houId") String houId, @Param("dorId") String dorId);

    //根据ID去修改寝室信息
    @Transactional()
    @Modifying
    @Query(nativeQuery = true, value = "update dorm set dor_id=:dorId,dor_sex=:dorIex,dor_num=:dorNum,tel=:tel,rich=:rich,dor_des=:dorDes where id=:id")
    int dormUpdate(@Param("id") Integer id, @Param("dorId") String dorId, @Param("dorIex") String dorIex, @Param("dorNum") Integer dorNum,  @Param("tel") String tel,@Param("rich") String rich, @Param("dorDes") String dorDes);

    //删除寝室信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete  from dorm  where  id in (:delId) ")
    int deleteDormById(@Param("delId") List<Integer> delId);

}
