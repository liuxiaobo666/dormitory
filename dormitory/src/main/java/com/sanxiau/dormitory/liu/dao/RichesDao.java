package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.Dorm;
import com.sanxiau.dormitory.liu.entity.Riches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 寝室财产
 */
@Repository
public interface RichesDao extends JpaRepository<Riches, Object> {

    //更据宿舍财产id去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from riches where id=:id ")
    List<Riches> findById(@Param("id") Integer id);

    //根据ID去修改寝室财产信息
    @Transactional()
    @Modifying
    @Query(nativeQuery = true, value = "update riches set bed_id=:bedId,stool_id=:stoolId,desk_id=:deskId,keysend=:keySend,ric_des=:ricDes where id=:id")
    int richesUpdate(@Param("id") Integer id, @Param("bedId") String bedId, @Param("stoolId") String stoolId, @Param("deskId") String deskId,@Param("keySend") String keySend, @Param("ricDes") String ricDes);

    //删除寝室信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete  from riches  where  id in (:delId) ")
    int deleteRichesById(@Param("delId") List<Integer> delId);

}
