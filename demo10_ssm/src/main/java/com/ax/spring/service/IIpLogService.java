package com.ax.spring.service;

import com.ax.spring.entity.IpLog;
import com.ax.spring.query.IpLogQueryObject;
import com.ax.spring.util.AXTools.AXPageResult;
import com.github.pagehelper.PageInfo;

public interface IIpLogService {

    AXPageResult query(IpLogQueryObject queryObject);

    void insert(IpLog ipLog);
    int queryForCount(IpLogQueryObject queryObject);


    PageInfo queryPage(IpLogQueryObject queryObject, int pageNum, int pageSize);

}
