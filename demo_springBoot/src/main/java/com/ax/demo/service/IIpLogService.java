package com.ax.demo.service;

import com.ax.demo.entity.IpLog;
import com.ax.demo.query.IpLogQueryObject;
import com.ax.demo.util.axtools.AxPageResult;


/**
 * @author axing
 */
public abstract class IIpLogService {

    public abstract AxPageResult query(IpLogQueryObject queryObject);

    public abstract void insert(IpLog ipLog);
    public abstract int queryForCount(IpLogQueryObject queryObject);


//    PageInfo queryPage(IpLogQueryObject queryObject, int pageNum, int pageSize);

}
