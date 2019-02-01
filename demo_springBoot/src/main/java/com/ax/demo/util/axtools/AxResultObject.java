package com.ax.demo.util.axtools;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.Date;
import java.util.List;

/**
 * @author axing
 */
public class AxResultObject {

    private Boolean state;
    private String msg;
    private List list;
    private String fileName;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date currentDate;


    public Date getCurrentDate() {
        return new Date();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
