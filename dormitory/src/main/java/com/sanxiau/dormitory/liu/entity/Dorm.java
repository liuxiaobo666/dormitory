package com.sanxiau.dormitory.liu.entity;

import javax.persistence.*;

/**
 * 宿舍实体类
 */
@Entity
@Table(name = "dorm")
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    //楼房号
    @Column(name = "hou_id")
    public String houId;
    //寝室号
    @Column(name = "dor_id")
    public String dorId;
    //寝室类型
    @Column(name = "dor_sex")
    public String dorIex;
    //应住人数
    @Column(name = "dor_num")
    public Integer dorNum;
    //实住人数
    @Column(name = "dor_price")
    public Integer dorPrice;
    //电话
    @Column(name = "tel")
    public String tel;
    //备注
    @Column(name = "dor_des")
    public String dorDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDorIex() {
        return dorIex;
    }

    public void setDorIex(String dorIex) {
        this.dorIex = dorIex;
    }

    public Integer getDorNum() {
        return dorNum;
    }

    public void setDorNum(Integer dorNum) {
        this.dorNum = dorNum;
    }

    public Integer getDorPrice() {
        return dorPrice;
    }

    public void setDorPrice(Integer dorPrice) {
        this.dorPrice = dorPrice;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDorDes() {
        return dorDes;
    }

    public void setDorDes(String dorDes) {
        this.dorDes = dorDes;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", houId='" + houId + '\'' +
                ", dorId='" + dorId + '\'' +
                ", dorIex='" + dorIex + '\'' +
                ", dorNum=" + dorNum +
                ", dorPrice=" + dorPrice +
                ", tel='" + tel + '\'' +
                ", dorDes='" + dorDes + '\'' +
                '}';
    }
}
