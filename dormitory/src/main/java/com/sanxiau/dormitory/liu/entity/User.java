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
}
