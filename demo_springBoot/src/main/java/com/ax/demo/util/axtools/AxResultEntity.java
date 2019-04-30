package com.ax.demo.util.axtools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author axing
 */
public class AxResultEntity<T> implements Serializable {

    private boolean state;

    private String msg;

    private T body;

    private transient AxReslutMessage message;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //@DatetimeFormat是将String转换成Date，一般前台给后台传值时用
    private Date currentDate;

    public AxReslutMessage getMessage() {
        return message;
    }

    public void setMessage(AxReslutMessage message) {
        this.message = message;
    }

    public Date getCurrentDate() {
        return new Date();
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
//        return this.message.getMsg();
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
