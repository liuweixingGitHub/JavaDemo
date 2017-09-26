package com.ax.spring.service.impl;


import com.ax.spring.domain.IpLog;
import com.ax.spring.domain.Userinfo;
import com.ax.spring.mapper.IpLogMapper;
import com.ax.spring.mapper.UserinfoMapper;
import com.ax.spring.service.ILoginService;
import com.ax.spring.util.AXTools.AXConst;
import com.ax.spring.context.UserinfoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Service
public class LoginServiceImp implements ILoginService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private IpLogMapper ipLogMapper;



    public Userinfo login(String username, String password,HttpServletRequest request){

        IpLog ipLog = new IpLog();
        ipLog.setIp(request.getRemoteAddr());
        ipLog.setLoginTime(new Date());
        ipLog.setUserName(username);;


        Userinfo userinfo = this.userinfoMapper.getModelByUsernameAndPassword(username,password);
        if (userinfo != null){
            /*
            登陆成功,保存当前登陆的userinfo
             */
            UserinfoContext.putUserinfo(userinfo);


            ipLog.setUserType(userinfo.getUsertype());
            ipLog.setUserinfoId(userinfo.getId());
            ipLog.setLoginState(IpLog.LOGINSTATE_SUCCESS);

        }else {
            ipLog.setLoginState(IpLog.LOGINSTATE_FAILD);

        }

        ipLogMapper.insert(ipLog);

        return userinfo;

    }

    public boolean hasAdmin(){

        return this.userinfoMapper.getCountByUsername(AXConst.ADMIN_NAME)>0;

    }
    public void createAdmin(){

        if (!hasAdmin()){

            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(AXConst.ADMIN_NAME);
            userinfo.setPassword(AXConst.ADMIN_PASSWORD);
            userinfo.setUsertype(userinfo.USERTYPE_SYSTEM);
            this.userinfoMapper.insert(userinfo);

        }

    }
}
