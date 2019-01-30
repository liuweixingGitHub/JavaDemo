package com.ax.demo.util.axtools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AXResultMap extends HashMap {


    private Boolean state;
    private List list;
    private String msg;
    private String fileName;

    public AXResultMap() {
        super();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
        this.put("state", state);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
        this.put("list", list);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.put("msg", msg);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.put("fileName", fileName);
    }

//    public String toJSONString(){
//
//       return JSON.toJSONString(this);
//
//    }

    /**
    返回成功list
     */
    public static AXResultMap succeeList(List list) {

        if (list == null) {
            list = new ArrayList();
        }
        AXResultMap result = new AXResultMap();
        result.setState(true);
        result.setList(list);

        return result;
    }

    /*
  返回成功list
   */
    public static AXResultMap succeeFileName(String name) {

        if (name == null) {
            name = "";
        }
        AXResultMap result = new AXResultMap();
        result.setState(true);
        result.setFileName(name);
        return result;
    }

    /*
    返回错误
     */
    public static AXResultMap errorMsg(String msg) {

        if (msg == null) {
            msg = "";
        }
        AXResultMap result = new AXResultMap();
        result.setState(false);
        result.setMsg(msg);
        return result;
    }
}
