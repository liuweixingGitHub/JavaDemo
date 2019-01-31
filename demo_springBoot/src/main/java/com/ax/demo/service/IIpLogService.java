package com.ax.demo.service;

import com.ax.demo.entity.IpLog;
import com.ax.demo.query.IpLogQueryObject;
import com.ax.demo.util.axtools.AxPageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * @author axing
 */
public interface IIpLogService {

     AxPageResult query(IpLogQueryObject queryObject);

      void insert(IpLog ipLog);
      int queryForCount(IpLogQueryObject queryObject);

      PageInfo<IpLog> findByPageInfo(int pageNum, int pageSize);

    Page<IpLog> findByPage(int pageNum, int pageSize);

//    PageInfo queryPage(IpLogQueryObject queryObject, int pageNum, int pageSize);

}
