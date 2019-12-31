package com.ax.shop.query;

import com.ax.shop.util.axUtil.AxQueryEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author axing
 */
public class IpLogQueryObject extends AxQueryEntity {

    private Date beginDate;
    private Date endDate;
    private String username;
    private int userType = -1;
    private boolean like;

    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
