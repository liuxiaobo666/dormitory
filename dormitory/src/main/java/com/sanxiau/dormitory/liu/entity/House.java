package com.sanxiau.dormitory.liu.entity;

import javax.persistence.*;

/**
 * 宿舍楼实体类
 */
@Entity
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //楼房号
    @Column(name = "hou_id")
    String houId;
    //地址
    @Column(name = "hou_add")
    String houAdd;
    //楼层数
    @Column(name = "hou_num")
    Integer houNum;
    //房间数
    @Column(name = "hou_rom")
    Integer houRom;
    //应住人数
    @Column(name = "hou_peo")
    Integer houPeo;
    //实住人数
    @Column(name = "hou_fact")
    Integer houFact;
    //管理账户
    @Column(name = "user_name")
    String userName;
    //备注
    @Column(name = "hou_des")
    String houDes;


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

    public String getHouAdd() {
        return houAdd;
    }

    public void setHouAdd(String houAdd) {
        this.houAdd = houAdd;
    }

    public Integer getHouNum() {
        return houNum;
    }

    public void setHouNum(Integer houNum) {
        this.houNum = houNum;
    }

    public Integer getHouRom() {
        return houRom;
    }

    public void setHouRom(Integer houRom) {
        this.houRom = houRom;
    }

    public Integer getHouPeo() {
        return houPeo;
    }

    public void setHouPeo(Integer houPeo) {
        this.houPeo = houPeo;
    }

    public Integer getHouFact() {
        return houFact;
    }

    public void setHouFact(Integer houFact) {
        this.houFact = houFact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHouDes() {
        return houDes;
    }

    public void setHouDes(String houDes) {
        this.houDes = houDes;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", houId='" + houId + '\'' +
                ", houAdd='" + houAdd + '\'' +
                ", houNum=" + houNum +
                ", houRom=" + houRom +
                ", houPeo=" + houPeo +
                ", houFact=" + houFact +
                ", userName='" + userName + '\'' +
                ", houDes='" + houDes + '\'' +
                '}';
    }
}
