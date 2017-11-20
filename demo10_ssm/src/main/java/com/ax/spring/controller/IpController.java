package com.ax.spring.controller;

import com.ax.spring.interceptor.RequiredLogin;
import com.ax.spring.query.IpLogQueryObject;
import com.ax.spring.util.AXTools.AXPageResult;
import com.ax.spring.service.IIpLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class IpController extends AccountController {

    @Autowired
    private IIpLogService ipLogService;


    @RequestMapping(value="/ip.do")
    @ResponseBody
    public AXPageResult test() {

        IpLogQueryObject queryObject = new IpLogQueryObject();

        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date beginDate = null;
        try {
            beginDate = dateFormat2.parse("2017-09-12 17:08:48.721");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        queryObject.setBeginDate(beginDate);


        Date endDate = null;
        try {
            endDate = dateFormat2.parse("2017-09-13 17:08:48.721");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        queryObject.setEndDate(endDate);

        queryObject.setCurrentPage(1);
        queryObject.setPageSize(10);
        queryObject.setLike(true);
        queryObject.setUserName("jim");
        queryObject.setUserType(0);


        AXPageResult result = ipLogService.query(queryObject);

        System.out.println("result = " + result);


        return result;

    }



}
