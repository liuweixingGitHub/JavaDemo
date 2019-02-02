package com.ax.demo.mapper;

import com.ax.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author axing
 */
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

    /**
       注册获得是否已经有了
      */
    int getCountByuserName(String userName);

    /**
    按照名userName查找
     */
    Userinfo getModelByuserName(String userName);

    /**
    *按照名userName和passwor查找
    */
    Userinfo getModelByuserNameAndpassWord(String userName,String passWord);

    /**
     * 查询所有
     * @return
     */
   List<Userinfo> getAll();

}