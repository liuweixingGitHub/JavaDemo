package com.ax.shop.dto;

import com.alibaba.fastjson.JSON;
import com.ax.shop.entity.IpLog;

import java.util.List;

public class UpdateListObject {

    private List<IpLog> list;
    private String name;

    public List<IpLog> getList() {
        return list;
    }

    public void setList(List<IpLog> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}