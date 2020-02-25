package com.ax.shop.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @author axing
 * implements Serializable redis 需要序列化
 */
public class IpLog implements Serializable {

    public static final int LOGINSTATE_FAILD;

    static {
        LOGINSTATE_FAILD = 0;
    }

    public static final int LOGINSTATE_SUCCESS;

    static {
        LOGINSTATE_SUCCESS = 1;
    }

    private Long id;

    private String username;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.SSSS")//页面写入数据库时格式
    @JSONField(format="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
    private Date loginTime;

//    /**测试时间格式化**/
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")//数据库导出页面时json格式化
//    private Date loginTimeStr;

//    public Date getLoginTimeStr() {
//        return loginTime;
//    }


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
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    @Override
    public String toString() {
        return "IpLog{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginTime=" + loginTime +
                ", ip='" + ip + '\'' +
                ", loginState=" + loginState +
                ", userType=" + userType +
                ", userinfoId=" + userinfoId +
                '}';
    }
}