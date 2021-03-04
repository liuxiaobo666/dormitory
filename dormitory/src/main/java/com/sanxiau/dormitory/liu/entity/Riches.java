package com.sanxiau.dormitory.liu.entity;


import javax.persistence.*;

/**
 * 寝室财产实体类
 */
@Entity
@Table(name = "riches")
public class Riches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //学号
    @Column(name = "stu_id")
    public String stuId;
    //姓名
    @Column(name = "stu_name")
    String stuName;
    //楼房号
    @Column(name = "hou_id")
    String houId;
    //寝室号
    @Column(name = "dor_id")
    String dorId;
    //床位
    @Column(name = "bed_id")
    String bedId;
    //凳子号
    @Column(name = "stool_id")
    String stoolId;
    //桌子号
    @Column(name = "desk_id")
    String deskId;
    //钥匙发放
    @Column(name = "keysend")
    String keySend;
    //备注
    @Column(name = "ric_des")
    String ricDes;

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

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public String getStoolId() {
        return stoolId;
    }

    public void setStoolId(String stoolId) {
        this.stoolId = stoolId;
    }

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }

    public String getKeySend() {
        return keySend;
    }

    public void setKeySend(String keySend) {
        this.keySend = keySend;
    }



    public String getRicDes() {
        return ricDes;
    }

    public void setRicDes(String ricDes) {
        this.ricDes = ricDes;
    }

    @Override
    public String toString() {
        return "Riches{" +
                "id=" + id +
                ", stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", houId='" + houId + '\'' +
                ", dorId='" + dorId + '\'' +
                ", bedId='" + bedId + '\'' +
                ", stoolId='" + stoolId + '\'' +
                ", deskId='" + deskId + '\'' +
                ", keySend='" + keySend + '\'' +
                ", ricDes='" + ricDes + '\'' +
                '}';
    }
}
