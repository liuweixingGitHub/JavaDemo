package com.ax.spring.service;

import com.ax.spring.domain.IpLog;
import com.ax.spring.query.IpLogQueryObject;
import com.ax.spring.util.AXTools.AXPageResult;

public interface IIpLogService {

    AXPageResult query(IpLogQueryObject queryObject);

    void insert(IpLog ipLog);
    int queryForCount(IpLogQueryObject queryObject);

}
