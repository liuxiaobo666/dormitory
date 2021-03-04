package com.sanxiau.dormitory.liu.entity;

import org.springframework.stereotype.Component;

//临时类
@Component
public class Dorms {
    String houId;
    String dorId;
    String dorPrice;

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

    public String getDorPrice() {
        return dorPrice;
    }

    public void setDorPrice(String dorPrice) {
        this.dorPrice = dorPrice;
    }

    @Override
    public String toString() {
        return "Dorms{" +
                "houId='" + houId + '\'' +
                ", dorId='" + dorId + '\'' +
                ", dorPrice='" + dorPrice + '\'' +
                '}';
    }
}
