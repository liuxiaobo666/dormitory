package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.House;
import com.sanxiau.dormitory.liu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 宿舍楼
 */
@Repository
public interface HouseDao extends JpaRepository<House, Object> {


    //更据宿舍id去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from house where id=:id")
    List<House> findById(@Param("id") Integer id);

    //统计宿舍楼的数量
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM house")
    int findCount();

    //更据宿舍楼编号去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from house where hou_id=:houId")
    List<House> findByHouId(@Param("houId") String houId);

    //根据ID去修改宿舍楼信息
    @Transactional()
    @Modifying
    @Query(nativeQuery = true, value = "update house  set hou_id=:houId,hou_add=:houAdd,hou_num=:houNum,hou_rom=:houRom,hou_peo=:houPeo,user_name=:userName,hou_des=:houDes where id =:id")
    int houseUpdate(@Param("id") Integer id, @Param("houId") String houId, @Param("houAdd") String houAdd, @Param("houNum") Integer houNum, @Param("houRom") Integer houRom, @Param("houPeo") Integer houPeo,  @Param("userName") String userName, @Param("houDes") String houDes);


    //对数据进行更改运算
    @Transactional()
    @Modifying
    @Query(nativeQuery = true, value = "update house  set hou_rom=:houRom,hou_peo=:houPeo where hou_Id =:houId")
    int updateHouseByHouId(@Param("houId") String houId, @Param("houRom") Integer houRom, @Param("houPeo") Integer houPeo);

    //删除楼房信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete  from house  where  id in (:delId) ")
    int deleteHouseById(@Param("delId") List<Integer> delId);

}
