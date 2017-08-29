package com.ax.spring.domain;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class AXResult {

    private Boolean result;
    private List list = new ArrayList();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AXResult() {
    }

    public AXResult(Boolean result, List list) {
        this.result = result;
        this.list = list;
    }

    public AXResult(Boolean result,String name) {
        this.result = result;
        this.name = name;
    }

    public String toJSONString(){

       return JSON.toJSONString(this);

    }
}
