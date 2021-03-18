package com.sanxiau.dormitory.liu.entity;


import javax.persistence.*;

/**
 * 卫生情况实体类
 */
@Entity
@Table(name = "dorsanit")
public class Dorsanit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //楼房号
    @Column(name = "hou_id")
    public String houId;
    //表扬
    @Column(name = "praise")
    String praise;
    //批评
    @Column(name = "criticism")
    String criticism;
    //值班人
    @Column(name = "watch")
    String watch;
    //日期
    @Column(name = "sanit_date")
    String sanitDate;
    //备注
    @Column(name = "sanit_des")
    String sanitDes;

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

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public String getCriticism() {
        return criticism;
    }

    public void setCriticism(String criticism) {
        this.criticism = criticism;
    }

    public String getWatch() {
        return watch;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }

    public String getSanitDate() {
        return sanitDate;
    }

    public void setSanitDate(String sanitDate) {
        this.sanitDate = sanitDate;
    }

    public String getSanitDes() {
        return sanitDes;
    }

    public void setSanitDes(String sanitDes) {
        this.sanitDes = sanitDes;
    }

    @Override
    public String toString() {
        return "Dorsanit{" +
                "id=" + id +
                ", houId='" + houId + '\'' +
                ", praise='" + praise + '\'' +
                ", criticism='" + criticism + '\'' +
                ", watch='" + watch + '\'' +
                ", sanitDate='" + sanitDate + '\'' +
                ", sanitDes='" + sanitDes + '\'' +
                '}';
    }
}
