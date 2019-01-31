package com.ax.demo.mapper;

import com.ax.demo.entity.IpLog;
import com.ax.demo.query.IpLogQueryObject;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author axing
 */
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

    List<IpLog> findByPageInfo();

    Page<IpLog> findByPage();
}