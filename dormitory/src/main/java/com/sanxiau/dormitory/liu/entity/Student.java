package com.sanxiau.dormitory.liu.entity;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
学生实体类
 */
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //学号
    @Column(name = "stu_id")
    public String stuId;
    //姓名
    @Column(name = "stu_name")
    String stuName;
    //性别
    @Column(name = "stu_sex")
    String stuSex;
    //身份证号码
    @Column(name = "id_card")
    String idCard;
    //楼房号
    @Column(name = "hou_id")
    String houId;
    //寝室号
    @Column(name = "dor_id")
    String dorId;
    //入学日期
    @Column(name = "stu_enr")
    String stuEnr;
    //出生日期
    @Column(name = "stu_birth")
    String stuBirth;
    //专业
    @Column(name = "stu_study")
    String stuStudy;
    //班级
    @Column(name = "stu_class")
    String stuClass;
    //辅导员
    @Column(name = "stu_cname")
    String stuCname;
    //政治面貌
    @Column(name = "stu_polit")
    String stuPolit;
    //家庭住址
    @Column(name = "stu_add")
    String stuAdd;
    //邮箱
    @Column(name = "email")
    String email;
    //联系方式
    @Column(name = "stu_tel")
    String stuTel;
    //在校状态
    @Column(name = "stu_sta")
    String stuSta;
    //照片
    @Column(name = "photo")
    String photo;
    //备注
    @Column(name = "stu_des")
    String stuDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getHouId() {
        return houId;
    }

    public void setHouId(String houId) {
        this.houId = houId;
    }

    public String getDorId() {
        return dorId;
    }

    public void setDorId(String dorId) {
        this.dorId = dorId;
    }

    public String getStuEnr() {

        return stuEnr;
    }

    public void setStuEnr(String stuEnr) {
        this.stuEnr = stuEnr;
    }

    public String getStuBirth()  {

        return stuBirth;
    }

    public void setStuBirth(String stuBirth) {
        this.stuBirth = stuBirth;
    }

    public String getStuStudy() {
        return stuStudy;
    }

    public void setStuStudy(String stuStudy) {
        this.stuStudy = stuStudy;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuCname() {
        return stuCname;
    }

    public void setStuCname(String stuCname) {
        this.stuCname = stuCname;
    }

    public String getStuPolit() {
        return stuPolit;
    }

    public void setStuPolit(String stuPolit) {
        this.stuPolit = stuPolit;
    }

    public String getStuAdd() {
        return stuAdd;
    }

    public void setStuAdd(String stuAdd) {
        this.stuAdd = stuAdd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuSta() {
        return stuSta;
    }

    public void setStuSta(String stuSta) {
        this.stuSta = stuSta;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStuDes() {
        return stuDes;
    }

    public void setStuDes(String stuDes) {
        this.stuDes = stuDes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", houId='" + houId + '\'' +
                ", dorId='" + dorId + '\'' +
                ", stuEnr=" + stuEnr +
                ", stuBirth=" + stuBirth +
                ", stuStudy='" + stuStudy + '\'' +
                ", stuClass='" + stuClass + '\'' +
                ", stuCname='" + stuCname + '\'' +
                ", stuPolit='" + stuPolit + '\'' +
                ", stuAdd='" + stuAdd + '\'' +
                ", email='" + email + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", stuSta='" + stuSta + '\'' +
                ", photo='" + photo + '\'' +
                ", stuDes='" + stuDes + '\'' +
                '}';
    }
}
