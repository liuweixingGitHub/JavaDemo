package com.ax.demo.service.impl;

import com.ax.demo.entity.IpLog;
import com.ax.demo.mapper.IpLogMapper;
import com.ax.demo.query.IpLogQueryObject;
import com.ax.demo.service.IIpLogService;
import com.ax.demo.util.axtools.AxPageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public AxPageResult query(IpLogQueryObject queryObject) {

        int  count = ipLogMapper.queryForCount(queryObject);

        if (count>0){

            List<IpLog> list = ipLogMapper.query(queryObject);


            return new AxPageResult(count,queryObject.getPageSize(),queryObject.getCurrentPage(),list);

        }
        return AxPageResult.empty(queryObject.getPageSize());
    }


    @Override
    public void insert(IpLog ipLog) {
        ipLogMapper.insert(ipLog);
    }

    @Override
    public int queryForCount(IpLogQueryObject queryObject) {
        return 0;
    }

    @Override
    public PageInfo<IpLog> findByPageInfo(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<IpLog> list = ipLogMapper.findByPage();

        PageInfo<IpLog> pageInfo = new PageInfo(list);

        return pageInfo;
    }

    @Override
    public Page<IpLog> findByPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        return ipLogMapper.findByPage();
    }
}
