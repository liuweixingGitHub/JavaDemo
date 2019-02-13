package com.ax.demo.controller;

import com.ax.demo.entity.IpLog;
import com.ax.demo.service.IIpLogService;
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
    public Object ipLogPageInfo(@RequestParam(value = "pageNum", required = true) int pageNum, @RequestParam(value = "pageSize", required = true) int pageSize) {
        return ipLogService.findByPageInfo(pageNum, pageSize);

    }

    /**
     * ipLogPage 只有数据
     */
    @RequestMapping(value = "/ipLogPage.do")
    public Object ipLogPage(@RequestParam(value = "pageNum", required = true) int pageNum, @RequestParam(value = "pageSize", required = true) int pageSize) {
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

        return ipLogService.updateByListWhen(list);
    }

    @RequestMapping(value = "/list.do")
    public void listParam(@RequestBody List<String> id) {

        System.out.println("param = " + id);
    }


}
