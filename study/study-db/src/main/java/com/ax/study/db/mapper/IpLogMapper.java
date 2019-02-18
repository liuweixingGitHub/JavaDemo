package com.ax.study.db.mapper;

import com.ax.study.db.entity.IpLog;
import com.ax.study.db.query.IpLogQueryObject;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author axing
 */
@Mapper
public interface IpLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(IpLog record);

    @InsertProvider(type=IpLogMapperSql.class,method="insertIpLog")
    int insertIpLog(IpLog ipLog);

    int insertSelective(IpLog record);


    @SelectProvider(type = IpLogMapperSql.class, method = "getById")
    IpLog selectByPrimaryKey(@Param("id") Long id);


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
     * 需要 url: jdbc:mysql://localhost:3306/demo10_p1?characterEncoding=utf-8&allowMultiQueries=true
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


}