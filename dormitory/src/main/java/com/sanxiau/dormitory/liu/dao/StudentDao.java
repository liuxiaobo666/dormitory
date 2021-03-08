package com.sanxiau.dormitory.liu.dao;

import com.sanxiau.dormitory.liu.entity.House;
import com.sanxiau.dormitory.liu.entity.Student;
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
public interface StudentDao extends JpaRepository<Student, Object> {


    //更据学生id去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from student where id=:id")
    List<Student> findById1(@Param("id") Integer id);



    //根据ID去修改学生信息
    @Transactional()
    @Modifying
    @Query(nativeQuery = true, value = "update student  set id_card=:idCard,hou_id=:houId,dor_id=:dorId,stu_study=:stuStudy,stu_class=:stuClass,stu_cname=:stuCname,stu_polit=:stuPolit,stu_add=:stuAdd,email=:email,stu_tel=:stuTel,stu_sta=:stuSta,stu_des=:stuDes where id =:id")
    int studentUpdate(@Param("id") Integer id, @Param("idCard") String idCard, @Param("houId") String houId, @Param("dorId") String dorId, @Param("stuStudy") String stuStudy, @Param("stuClass") String stuClass, @Param("stuCname") String stuCname, @Param("stuPolit") String stuPolit, @Param("stuAdd") String stuAdd, @Param("email") String email, @Param("stuTel") String stuTel, @Param("stuSta") String stuSta, @Param("stuDes") String stuDes);



}
