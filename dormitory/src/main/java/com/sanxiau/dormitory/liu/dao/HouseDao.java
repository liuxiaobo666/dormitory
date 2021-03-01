package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 宿舍楼
 */
@Repository
public interface HouseDao extends JpaRepository<House,Object> {
}
