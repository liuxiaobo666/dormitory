package com.sanxiau.dormitory.liu.entity;


import javax.persistence.*;

/**
 * 公告实体类
 */
@Entity
@Table(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //日期
    @Column(name = "date")
    public String date;
    //标题
    @Column(name = "title")
    String title;
    //内容
    @Column(name = "text")
    String text;
    //发布人
    @Column(name = "issuer")
    String issuer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}
