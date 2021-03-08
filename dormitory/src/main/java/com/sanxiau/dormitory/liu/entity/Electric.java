package com.sanxiau.dormitory.liu.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 电费实体类
 */
@Entity
@Table(name = "electric")
public class Electric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //月份
    @Column(name = "pay_month")
    String payMonth;
    //楼房号
    @Column(name = "hou_id")
    String houId;
    //寝室号
    @Column(name = "dor_id")
    String dorId;
    //度数
    @Column(name = "degrees")
    Double degrees;
    //单价
    @Column(name = "price")
    BigDecimal price;
    //总费用
    @Column(name = "all_price")
    BigDecimal allPrice;
    //处理人
    @Column(name = "conductor")
    String conductor;
    //处理人账号
    @Column(name = "handle_user")
    String handleUser;
    //缴费账号
    @Column(name = "pay_user")
    String payUser;
    //缴费时间
    @Column(name = "pay_date")
    String payDate;
    //缴费方式
    @Column(name = "pay_type")
    String payType;
    //缴费状态
    @Column(name = "pay_state")
    String payState;
    //备注
    @Column(name = "ele_des")
    String eleDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
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

    public Double getDegrees() {
        return degrees;
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(BigDecimal allPrice) {
        this.allPrice = allPrice;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getHandleUser() {
        return handleUser;
    }

    public void setHandleUser(String handleUser) {
        this.handleUser = handleUser;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public String getEleDes() {
        return eleDes;
    }

    public void setEleDes(String eleDes) {
        this.eleDes = eleDes;
    }

    @Override
    public String toString() {
        return "Electric{" +
                "id=" + id +
                ", payMonth='" + payMonth + '\'' +
                ", houId='" + houId + '\'' +
                ", dorId='" + dorId + '\'' +
                ", degrees=" + degrees +
                ", price=" + price +
                ", allPrice=" + allPrice +
                ", conductor='" + conductor + '\'' +
                ", handleUser='" + handleUser + '\'' +
                ", payUser='" + payUser + '\'' +
                ", payDate='" + payDate + '\'' +
                ", payType='" + payType + '\'' +
                ", payState='" + payState + '\'' +
                ", eleDes='" + eleDes + '\'' +
                '}';
    }
}
