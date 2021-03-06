package com.ax.spring.service.impl;


import com.ax.spring.entity.IpLog;
import com.ax.spring.entity.Userinfo;
import com.ax.spring.mapper.IpLogMapper;
import com.ax.spring.mapper.UserinfoMapper;
import com.ax.spring.service.ILoginService;
import com.ax.spring.util.AXTools.AXConst;
import com.ax.spring.context.UserinfoContext;
import com.ax.spring.util.AXTools.AXResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class LoginServiceImp implements ILoginService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private IpLogMapper ipLogMapper;

    @Override
    public Userinfo login(String username, String password, HttpServletRequest request) {

        IpLog ipLog = new IpLog();
        ipLog.setIp(request.getRemoteAddr());
        ipLog.setLoginTime(new Date());
        ipLog.setUserName(username);


        Userinfo userinfo = this.userinfoMapper.getModelByUsernameAndPassword(username, password);
        if (userinfo != null) {
            /*
            登陆成功,保存当前登陆的userinfo
             */
            UserinfoContext.putUserinfo(userinfo);


            ipLog.setUserType(userinfo.getUsertype());
            ipLog.setUserinfoId(userinfo.getId());
            ipLog.setLoginState(IpLog.LOGINSTATE_SUCCESS);

            ipLogMapper.insert(ipLog);
        } else {
            ipLog.setLoginState(IpLog.LOGINSTATE_FAILD);

        }


        return userinfo;

    }

    @Override
    public AXResultMap loginState(String username, String password, HttpServletRequest request) {


        Userinfo userinfo = this.userinfoMapper.getModelByUsername(username.toLowerCase());

        System.out.println("userinfo = " + userinfo);


        AXResultMap axResultMap = new AXResultMap();

        if (userinfo == null) {


            axResultMap.setState(false);
            axResultMap.setMsg("账号不存在");


        } else {


            /**记录登录成功或失败*/
            IpLog ipLog = new IpLog();
            ipLog.setIp(request.getRemoteAddr());
            ipLog.setLoginTime(new Date());
            ipLog.setUserName(username.toLowerCase());
            ipLog.setUserType(userinfo.getUsertype());
            ipLog.setUserinfoId(userinfo.getId());

            if (userinfo.getPassword().toLowerCase().equals(password.toLowerCase())) {

                /**登陆成功,保存当前登陆的userinfo*/
                UserinfoContext.putUserinfo(userinfo);
                ipLog.setLoginState(IpLog.LOGINSTATE_SUCCESS);

                axResultMap.setState(true);
                axResultMap.put("userinfo", userinfo);

            } else {

                ipLog.setLoginState(IpLog.LOGINSTATE_FAILD);
                axResultMap.setState(false);
                axResultMap.setMsg("账号或者密码错误");

            }
            ipLogMapper.insert(ipLog);
        }


        return axResultMap;

    }

    @Override
    public boolean hasAdmin() {

        return this.userinfoMapper.getCountByUsername(AXConst.ADMIN_NAME) > 0;

    }

    @Override
    public void createAdmin() {

        if (!hasAdmin()) {

            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(AXConst.ADMIN_NAME);
            userinfo.setPassword(AXConst.ADMIN_PASSWORD);
            userinfo.setUsertype(Userinfo.USERTYPE_SYSTEM);
            this.userinfoMapper.insert(userinfo);

        }

    }
}
