package com.ax.shop.mapper;

import com.ax.shop.entity.IpLog;
import com.ax.shop.query.IpLogQueryObject;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author axing
 */
@SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")

public interface IpLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(IpLog record);

    int insertSelective(IpLog record);

    IpLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IpLog record);

    int updateByPrimaryKey(IpLog record);

    /**
     * 分页查询 个数
     */
    int queryForCount(IpLogQueryObject queryObject);

    /**
     * 分页查询 内容
     */
    List<IpLog> query(IpLogQueryObject queryObject);

    List<IpLog> queryPage(IpLogQueryObject queryObject);

    List<IpLog> findByPageInfo();


    Page<IpLog> findByPage();


    int deleteByIdList(List<Long> ids);

    int insertList(List<IpLog> list);

    /**
     * 批量更新,多个sql,
     * 需要 url: jdbc:mysql://localhost:3306/10_p1?characterEncoding=utf-8&allowMultiQueries=true
     *
     * @param list
     * @return
     */
    int updateByList(List<IpLog> list);

    /**
     * 批量更新,拼接一条sql
     *
     * @param list
     * @return
     */
    int updateByListWhen(List<IpLog> list);


    int deleteById(int id);
}