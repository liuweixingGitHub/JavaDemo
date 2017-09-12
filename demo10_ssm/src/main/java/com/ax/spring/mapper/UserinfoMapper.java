package com.ax.spring.mapper;

import com.ax.spring.domain.Userinfo;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int insert(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int insertSelective(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    Userinfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Userinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_userinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Userinfo record);

    /*
  注册获得是否已经有了
   */
    int getCountByUsername(@Param("username") String username);

    /*
    按照名username查找
     */
    Userinfo getModelByUsername(@Param("username") String username);

    /*
   按照名username和passwor查找
    */
    Userinfo getModelByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}