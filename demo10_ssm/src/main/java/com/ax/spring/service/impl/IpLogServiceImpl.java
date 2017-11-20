package com.ax.spring.service.impl;

import com.ax.spring.entity.IpLog;
import com.ax.spring.mapper.IpLogMapper;
import com.ax.spring.query.IpLogQueryObject;
import com.ax.spring.util.AXTools.AXPageResult;
import com.ax.spring.service.IIpLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpLogServiceImpl implements IIpLogService {

    @Autowired
    private IpLogMapper ipLogMapper;


    @Override
    public AXPageResult query(IpLogQueryObject queryObject) {

        int  count = ipLogMapper.queryForCount(queryObject);

        if (count>0){

            List<IpLog> list = ipLogMapper.query(queryObject);


            return new AXPageResult(count,queryObject.getPageSize(),queryObject.getCurrentPage(),list);

        }
        return AXPageResult.empty(queryObject.getPageSize());
    }



    public PageInfo queryPage(IpLogQueryObject queryObject, int pageNum,int pageSize) {


        System.out.println("pageNo = " + pageNum);

        PageHelper.startPage(pageNum, pageSize);

        List<IpLog> list =  ipLogMapper.queryPage(queryObject);



        System.out.println("list = " + list);

        PageInfo<IpLog> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public void insert(IpLog ipLog) {

    }

    public int queryForCount(IpLogQueryObject queryObject){
        return ipLogMapper.queryForCount(queryObject);

    }
}
