package com.ax.demo.service;

import com.ax.demo.entity.IpLog;
import com.ax.demo.query.IpLogQueryObject;
import com.ax.demo.util.axtools.AXPageResult;


public interface IIpLogService {

    AXPageResult query(IpLogQueryObject queryObject);

    void insert(IpLog ipLog);
    int queryForCount(IpLogQueryObject queryObject);


//    PageInfo queryPage(IpLogQueryObject queryObject, int pageNum, int pageSize);

}
