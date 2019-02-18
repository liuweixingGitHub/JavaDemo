package com.ax.study.all.controller;

import com.alibaba.fastjson.JSON;
import com.ax.study.db.entity.IpLog;
import com.ax.study.all.service.IIpLogService;
import com.ax.study.all.util.axtools.AxResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author axing
 */
@RestController
public class IpLogController {

    @Autowired
    IIpLogService ipLogService;

    /**
     * PageInfo 含有页面信息
     */
    @RequestMapping(value = "/ipLogPageInfo.do")
    public Object ipLogPageInfo(@RequestParam(value = "pageNum", required = true) int pageNum,
                                @RequestParam(value = "pageSize", required = true) int pageSize) {
        return ipLogService.findByPageInfo(pageNum, pageSize);

    }

    /**
     * ipLogPage 只有数据
     */
    @RequestMapping(value = "/ipLogPage.do")
    public Object ipLogPage(@RequestParam(value = "pageNum") int pageNum,
                            @RequestParam(value = "pageSize") int pageSize) {
        return ipLogService.findByPage(pageNum, pageSize);

    }

    /**
     * ipLogPage 只有数据
     */
    @RequestMapping(value = "/ipLogAll.do")
    public Object ipLogAll() {
        return ipLogService.findAll();
    }

    @RequestMapping(value = "/getIpLog.do")
    public Object getByKey(Long id) {
        return ipLogService.getByKey(id);

    }

    @RequestMapping(value = "/updateIplog.do")
    public int updateByEntity(IpLog ipLog) {

        return ipLogService.updateByEntity(ipLog);
    }

    @RequestMapping(value = "/updateList.do")
    public Object updateByList(@RequestBody(required = false) List<IpLog> list) {
        System.out.println("list = " + list);
        return ipLogService.updateByListWhen(list);
    }

    @RequestMapping(value = "/updateList2.do")
    public Object updateByList2(@RequestBody(required = false) UpdateListObject object) {

        System.out.println("name = " + object);

        return new AxResultEntity();
    }

    @RequestMapping(value = "/list.do")
    public void listParam(@RequestBody List<String> list, String name) {

        System.out.println("list = " + list);
        System.out.println("name = " + name);
    }

}

class UpdateListObject {

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