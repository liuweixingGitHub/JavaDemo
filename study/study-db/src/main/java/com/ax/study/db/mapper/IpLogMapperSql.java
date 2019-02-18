package com.ax.study.db.mapper;

import com.ax.study.db.entity.IpLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

public class IpLogMapperSql {

    private final String T_IPLOG = "t_ipLog";

//    public String getById(Long id) {
//        System.out.println("id = " + id);
//        return "select * from t_ipLog where id=#{id}";
//    }

    public String getById(Long id) {

        return new SQL() {
            {
                SELECT("*");
                FROM(T_IPLOG);
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String insertIpLog(IpLog ipLog) {

        return new SQL() {
            {
                INSERT_INTO(T_IPLOG);

                String username = ipLog.getUserName();
                if (null != username && !"".equals(username)) {
                    VALUES("username", "#{username}");
                }

                Date loginTime = ipLog.getLoginTime();
                if (null != loginTime && !"".equals(loginTime)) {
                    VALUES("loginTime", "#{loginTime}");
                }

                String ip = ipLog.getIp();
                if (null != ip && !"".equals(ip)) {
                    VALUES("ip", "#{ip}");
                }

                Integer loginState = ipLog.getLoginState();
                if (null != loginState && !"".equals(loginState)) {
                    VALUES("loginState", "#{loginState}");
                }

                Integer userType = ipLog.getUserType();
                if (null != userType && !"".equals(userType)) {
                    VALUES("userType", "#{userType}");
                }

                Long userinfoId = ipLog.getUserinfoId();
                if (null != userinfoId && !"".equals(userinfoId)) {
                    VALUES("userinfoId", "#{userinfoId}");
                }
            }
        }.toString();
    }


    public String updateIpLog(IpLog ipLog) {

        String sql = new SQL() {
            {
                UPDATE(T_IPLOG);

                String userName = ipLog.getUserName();
                if (null != userName && !"".equals(userName)) {
                    SET("userName=#{userName}");
                }

                Date loginTime = ipLog.getLoginTime();
                if (null != loginTime && !"".equals(loginTime)) {
                    SET("loginTime=#{loginTime}");
                }

                String ip = ipLog.getIp();
                if (null != ip && !"".equals(ip)) {
                    SET("ip=#{ip}");
                }

                Integer loginState = ipLog.getLoginState();
                if (null != loginState && !"".equals(loginState)) {
                    SET("loginState=#{loginState}");
                }

                Integer userType = ipLog.getUserType();
                if (null != userType && !"".equals(userType)) {
                    SET("userType=#{userType}");
                }

                Long userinfoId = ipLog.getUserinfoId();
                if (null != userinfoId && !"".equals(userinfoId)) {
                    SET("userinfoId=#{userinfoId}");
                }

                Long id = ipLog.getId();
                WHERE("id=#{id}");
            }
        }.toString();

        System.out.println("sql = " + sql);
        return sql;

    }

    public String deleteOne(Long id){
        return new SQL(){{
            DELETE_FROM(T_IPLOG);
            WHERE("id=#{id}");
        }}.toString();
    }
}
