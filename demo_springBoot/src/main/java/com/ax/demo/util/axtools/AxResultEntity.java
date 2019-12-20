package com.ax.demo.util.axtools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author axing
 */
public class AxResultEntity<T> implements Serializable {

    private boolean state;
    private String msg;
    private T data;
    private transient AxReslutMessage message;
    private AxResultStatus resultStatus;

    public AxResultEntity() {
    }

    public AxResultEntity(AxResultStatus resultStatus, T data) {
        this.resultStatus = resultStatus;
        this.data = data;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //@DatetimeFormat是将String转换成Date，一般前台给后台传值时用
    private Date date;


    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> AxResultEntity<T> success(AxResultStatus resultStatus, T data) {
        if (resultStatus == null) {
            return new AxResultEntity<T>(AxResultStatus.SUCCESS, data);
        }
        return new AxResultEntity<T>(resultStatus, data);
    }


    /**
     * 业务成功返回业务代码,描述和返回的参数
     */
    public static <T> AxResultEntity<T> Success(T data) {
        return new AxResultEntity<T>(AxResultStatus.SUCCESS, data);
    }


    public AxReslutMessage getMessage() {
        return message;
    }

    public void setMessage(AxReslutMessage message) {
        this.message = message;
    }

    public Date getDate() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
