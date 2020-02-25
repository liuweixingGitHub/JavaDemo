package com.ax.spring.mapper;

import com.ax.spring.entity.IpLog;
import com.ax.spring.query.IpLogQueryObject;
import java.util.List;

public interface IpLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IpLog record);

    int insertSelective(IpLog record);

    IpLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IpLog record);

    int updateByPrimaryKey(IpLog record);

    /**
    分页查询 个数
     */
    int queryForCount(IpLogQueryObject queryObject);

    /**
    分页查询 内容
     */
    List<IpLog> query(IpLogQueryObject queryObject);

    List<IpLog> queryPage(IpLogQueryObject queryObject);



}