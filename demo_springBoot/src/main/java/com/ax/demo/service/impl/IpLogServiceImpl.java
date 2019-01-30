package com.ax.demo.service.impl;

import com.ax.demo.entity.IpLog;
import com.ax.demo.mapper.IpLogMapper;
import com.ax.demo.query.IpLogQueryObject;
import com.ax.demo.service.IIpLogService;
import com.ax.demo.util.axtools.AXPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author axing
 */
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


    @Override
    public void insert(IpLog ipLog) {

    }

    @Override
    public int queryForCount(IpLogQueryObject queryObject) {
        return 0;
    }

}
