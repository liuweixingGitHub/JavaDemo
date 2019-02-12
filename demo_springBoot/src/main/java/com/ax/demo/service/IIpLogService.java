package com.ax.demo.service;

import com.ax.demo.entity.IpLog;
import com.ax.demo.query.IpLogQueryObject;
import com.ax.demo.util.axtools.AxPageResultEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * @author axing
 */
public interface IIpLogService {

    /**
     * 查询
     * @param queryObject
     * @return AxPageResultEntity
     */
     AxPageResultEntity query(IpLogQueryObject queryObject);

    IpLog getByKey(Long id);

    /**
     * 插入
     * @param ipLog
     */
      void insert(IpLog ipLog);

    /**
     * 查询
     * @param queryObject
     * @return int
     */
    int queryForCount(IpLogQueryObject queryObject);

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return PageInfo
     */
      PageInfo<IpLog> findByPageInfo(int pageNum, int pageSize);

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return Page
     */
    Page<IpLog> findByPage(int pageNum, int pageSize);

    List<IpLog> findAll();

//    PageInfo queryPage(IpLogQueryObject queryObject, int pageNum, int pageSize);

}
