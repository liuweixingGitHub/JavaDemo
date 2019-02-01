package com.ax.demo.controller;

import com.ax.demo.service.IIpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author axing
 */
@RestController
public class IpLogController {
    @Autowired
    IIpLogService ipLogService;

    /**PageInfo 含有页面信息*/
    @RequestMapping(value = "/ipLogPageInfo.do")
    public Object ipLogPageInfo(@RequestParam(value = "pageNum",required = true) int pageNum, @RequestParam(value = "pageSize" ,required = true) int pageSize) {
        return ipLogService.findByPageInfo(pageNum,pageSize);

    }

    /**ipLogPage 只有数据*/
    @RequestMapping(value = "/ipLogPage.do")
    public Object ipLogPage(@RequestParam(value = "pageNum",required = true) int pageNum, @RequestParam(value = "pageSize" ,required = true) int pageSize) {
         return ipLogService.findByPage(pageNum,pageSize);

    }

}
