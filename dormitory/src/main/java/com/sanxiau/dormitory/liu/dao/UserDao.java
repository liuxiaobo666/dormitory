package com.sanxiau.dormitory.liu.dao;


import com.sanxiau.dormitory.liu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 用户
 */
@Repository
public interface UserDao extends JpaRepository<User, Object> {

    //查询状态为1的用户的信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from loginin where state='1'")
    List<User> findUserByState();

    //根据用户名去修用户状态
    @Transactional()
    @Modifying
    @Query(nativeQuery = true, value = "update loginin set state=:state where user_name =:userName")
    int updateUserByUserName(@Param("userName") String userName, @Param("state") String state);

    //更据用户名查询用户的信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from loginin where user_name:userName")
    User findUserByUserName(@Param("userName") String userName);


}
