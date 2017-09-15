package com.ax.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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