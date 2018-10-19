package com.wuxingfei.bean;

import org.apache.ibatis.jdbc.Null;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/29 0029.
 */
public class User {

    private Integer id;//主键ID

    private  Integer age;//年龄

    private  String userName;//用户名

    private  String password;//密码

    private Date birthday;//出生日期

    private String nativePlace ;//籍贯
    private String  phone; //电话
    private  String job;//职位
    /**
     * 0 -禁用 1启用 ，默认启用
     */
    private int isUse =1;//是否启用

    private String  relation ;//关系

    private String  remark;//备注

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
