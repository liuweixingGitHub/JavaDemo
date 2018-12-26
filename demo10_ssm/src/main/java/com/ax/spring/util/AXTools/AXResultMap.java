package com.ax.spring.util.AXTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AXResultMap extends HashMap{

    private Boolean success;
    private List list;
    private String msg;
    private String fileName;

    public AXResultMap() {
        super();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
        this.put("state",success);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
        this.put("list",list);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.put("msg",msg);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.put("fileName",fileName);
    }

//    public String toJSONString(){
//
//       return JSON.toJSONString(this);
//
//    }

    /*
    返回成功list
     */
    public  static AXResultMap succeeList(List list) {

        if (list==null){
            list = new ArrayList();
        }
        AXResultMap result = new AXResultMap();
        result.setSuccess(true );
        result.setList(list);

        return result;
    }

    /*
  返回成功list
   */
    public  static AXResultMap succeeFileName(String name) {

        if (name==null){
            name = "";
        }
        AXResultMap result = new AXResultMap();
        result.setSuccess(true );
        result.setFileName(name);
        return result;
    }

    /*
    返回错误
     */
    public  static AXResultMap errorMsg(String msg) {

        if (msg==null){
            msg = "";
        }
        AXResultMap result = new AXResultMap();
        result.setSuccess(false );
        result.setMsg(msg);
        return result;
    }
}
