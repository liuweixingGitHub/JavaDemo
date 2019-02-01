package com.ax.demo.service.impl;


import com.ax.demo.context.UserinfoContext;
import com.ax.demo.entity.IpLog;
import com.ax.demo.entity.Userinfo;
import com.ax.demo.mapper.IpLogMapper;
import com.ax.demo.mapper.UserinfoMapper;
import com.ax.demo.service.ILoginService;
import com.ax.demo.util.axtools.AxConst;
import com.ax.demo.util.axtools.AxResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
/**
 * @author axing
 */
@Service
public class LoginServiceImpl implements ILoginService {

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
    public AxResultMap loginState(String username, String password, HttpServletRequest request) {


        Userinfo userinfo = this.userinfoMapper.getModelByUsername(username.toLowerCase());

        System.out.println("userinfo = " + userinfo);


        AxResultMap axResultMap = new AxResultMap<String,Object>();

        if (userinfo == null) {


            axResultMap.setState(false);
            axResultMap.setMsg("账号不存在");


        } else {

            /*记录登录成功或失败*/
            IpLog ipLog = new IpLog();
            ipLog.setIp(request.getRemoteAddr());
            ipLog.setLoginTime(new Date());
            ipLog.setUserName(username.toLowerCase());
            ipLog.setUserType(userinfo.getUsertype());
            ipLog.setUserinfoId(userinfo.getId());

            if (userinfo.getPassword().toLowerCase().equals(password.toLowerCase())) {

                /*登陆成功,保存当前登陆的userinfo*/
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

        return this.userinfoMapper.getCountByUsername(AxConst.ADMIN_NAME) > 0;

    }

    @Override
    public void createAdmin() {

        if (!hasAdmin()) {

            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(AxConst.ADMIN_NAME);
            userinfo.setPassword(AxConst.ADMIN_PASSWORD);
            userinfo.setUsertype(Userinfo.USERTYPE_SYSTEM);
            this.userinfoMapper.insert(userinfo);

        }

    }
}
