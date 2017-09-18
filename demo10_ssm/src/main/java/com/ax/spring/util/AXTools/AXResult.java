package com.ax.spring.util.AXTools;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class AXResult {

    private Boolean success;
    private List list;
    private String msg;
    private String fileName;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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
        result.setSuccess(true );
        result.setList(list);
        return result.toJSONString();
    }

    /*
  返回成功list
   */
    public  static String succeeFileName(String name) {

        if (name==null){
            name = "";
        }
        AXResult result = new  AXResult ();
        result.setSuccess(true );
        result.setFileName(name);
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
        result.setSuccess(false );
        result.setMsg(msg);
        return result.toJSONString();
    }
}