package com.ax.demo.util.axtools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author axing
 */
public class AxResponseEntity<T> {

    private boolean state;

    private String msg;

    private T body;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //@DatetimeFormat是将String转换成Date，一般前台给后台传值时用
    private Date currentDate;


    public Date getCurrentDate() {
        return new Date();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
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
        return "AxResponseEntity{" +
                "state=" + state +
                ", msg='" + msg + '\'' +
                ", body=" + body +
                ", currentDate=" + currentDate +
                '}';
    }


//    @Override
//    public String toString() {
//        return JSON.toJSONString(this);
////        return "AxResponseEntity{" +
////                "state=" + state +
////                ", msg='" + msg + '\'' +
////                ", body=" + body +
////                ", currentDate=" + currentDate +
////                '}';
//    }
}
