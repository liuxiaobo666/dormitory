package com.sanxiau.dormitory.liu.entity;


import javax.persistence.*;

@Entity
@Table(name = "loginin")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;
    //用户名
    @Column(name = "user_name")
    public String userName;
    //用户密码
    @Column(name = "user_pwd")
    String userPwd;
    //用户权限
    @Column(name = "user_power")
    String userPower;
    //真实姓名
    @Column(name = "true_name")
    String trueName;
    //联系电话
    @Column(name = "link_tel")
    String linkTel;
    //邮箱
    @Column(name = "email")
    String email;
    //地址
    @Column(name = "link_addre")
    String linkAddre;
    //在职状态
    @Column(name = "state")
    String state;
    //身份证号码
    @Column(name = "id_card")
    String idCard;
    //备注
    @Column(name = "remark")
    String remark;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkAddre() {
        return linkAddre;
    }

    public void setLinkAddre(String linkAddre) {
        this.linkAddre = linkAddre;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPower='" + userPower + '\'' +
                ", trueName='" + trueName + '\'' +
                ", linkTel='" + linkTel + '\'' +
                ", email='" + email + '\'' +
                ", linkAddre='" + linkAddre + '\'' +
                ", state='" + state + '\'' +
                ", idCard='" + idCard + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
