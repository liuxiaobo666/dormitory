package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.Dorm;
import com.sanxiau.dormitory.liu.entity.Electric;
import com.sanxiau.dormitory.liu.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 电费
 */
@Repository
public interface ElectricDao extends JpaRepository<Electric, Object> {


    //更据电费月份和寝室号去查询
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from electric where dor_Id=:dorId and pay_Month=:payMonth")
    List<Electric> findByDateAndDorId(@Param("dorId") String dorId,@Param("payMonth") String payMonth);

    //根据id去缴费
    @Transactional()
    @Modifying
    @Query(nativeQuery = true, value = "update electric set pay_date=:payDate,pay_state=:payState,ele_des=:eleDes where id=:id")
    int electricUpdateById(@Param("id") Integer id, @Param("payDate") String payDate, @Param("payState") String payState,@Param("eleDes") String eleDes);

    //更据Id查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from electric where id=:id")
     List<Electric> findById1(@Param("id") Integer id);


}
