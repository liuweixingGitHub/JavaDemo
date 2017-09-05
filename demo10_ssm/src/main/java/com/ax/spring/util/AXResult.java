package com.ax.spring.util;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class AXResult {

    private Boolean result;
    private List list;
    private String msg;
    private String name;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toJSONString(){

       return JSON.toJSONString(this);

    }

    /*
    返回成功list
     */
    public  static String succeeList(List list) {

        if (list==null){
            list = new ArrayList();
        }
        AXResult result = new  AXResult ();
        result.setResult(true );
        result.setList(list);
        return result.toJSONString();
    }

    /*
  返回成功list
   */
    public  static String succeeName(String name) {

        if (name==null){
            name = "";
        }
        AXResult result = new  AXResult ();
        result.setResult(true );
        result.setName(name);
        return result.toJSONString();
    }

    /*
    返回错误
     */
    public  static String errorMsg(String msg) {

        if (msg==null){
            msg = "";
        }
        AXResult result = new  AXResult ();
        result.setResult(false );
        result.setMsg(msg);
        return result.toJSONString();
    }
}
