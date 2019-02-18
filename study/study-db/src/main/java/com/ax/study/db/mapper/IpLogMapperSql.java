package com.ax.study.db.mapper;

import com.ax.study.db.entity.IpLog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

public class IpLogMapperSql {

    private final String T_IPLOG = "t_ipLog";

    public String getById(Long id) {
        System.out.println("id = " + id);
        return "select * from t_ipLog where id=#{id}";
    }

    /**
     * 方式2：也可以根据官方提供的API来编写动态SQL。
     */
    public String insertSelective(@Param("username") String username, @Param("password") String password) {

        return new SQL() {
            {
                SELECT("*");
                FROM("t_user");
                if (username != null && password != null) {
                    WHERE("username like #{username} and password like #{password}");
                } else {
                    WHERE("1=2");
                }
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


}
