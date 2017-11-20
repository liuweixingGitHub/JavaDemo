package com.ax.spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;



public class IpLog {

    public static final int LOGINSTATE_FAILD;

    static {
        LOGINSTATE_FAILD = 0;
    }

    public static final int LOGINSTATE_SUCCESS;

    static {
        LOGINSTATE_SUCCESS = 1;
    }

    private Long id;

    private String userName;

    private Date loginTime;

    private String ip;

    private Integer loginState;

    private Integer userType;

    private Long userinfoId;


    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getLoginState() {
        return loginState;
    }

    public void setLoginState(Integer loginState) {
        this.loginState = loginState;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Long getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(Long userinfoId) {
        this.userinfoId = userinfoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }


    @Override
    public String toString() {
        return "IpLog{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", loginTime=" + loginTime +
                ", ip='" + ip + '\'' +
                ", loginState=" + loginState +
                ", userType=" + userType +
                ", userinfoId=" + userinfoId +
                '}';
    }
}