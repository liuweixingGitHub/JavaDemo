package com.ax.demo.query;

import com.ax.demo.util.axtools.AXQueryObject;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class IpLogQueryObject extends AXQueryObject {

    private Date beginDate;
    private Date endDate;
    private String userName;
    private int userType = -1;
    private boolean like;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
