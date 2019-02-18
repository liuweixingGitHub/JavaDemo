package com.ax.study.all.service.impl;


import com.ax.study.all.context.UserinfoContext;
import com.ax.study.all.service.ILoginService;
import com.ax.study.all.util.axtools.AxConst;
import com.ax.study.all.util.axtools.AxResultEntity;
import com.ax.study.db.entity.IpLog;
import com.ax.study.db.entity.Userinfo;
import com.ax.study.db.mapper.IpLogMapper;
import com.ax.study.db.mapper.UserinfoMapper;
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
    public Userinfo login(String userName, String passWord, HttpServletRequest request) {

        IpLog ipLog = new IpLog();
        ipLog.setIp(request.getRemoteAddr());
        ipLog.setLoginTime(new Date());
        ipLog.setUserName(userName);


        Userinfo userinfo = this.userinfoMapper.getModelByuserNameAndpassWord(userName, passWord);
        if (userinfo != null) {
            /*
            登陆成功,保存当前登陆的userinfo
             */
            UserinfoContext.putUserinfo(userinfo);

            ipLog.setUserType(userinfo.getUserType());
            ipLog.setUserinfoId(userinfo.getId());
            ipLog.setLoginState(IpLog.LOGINSTATE_SUCCESS);

            ipLogMapper.insert(ipLog);
        } else {
            ipLog.setLoginState(IpLog.LOGINSTATE_FAILD);

        }


        return userinfo;

    }

    @Override
    public Object loginState(String userName, String passWord, HttpServletRequest request) {


        Userinfo userinfo = this.userinfoMapper.getModelByuserName(userName.toLowerCase());

        System.out.println("userinfo = " + userinfo);


        AxResultEntity<Userinfo> responseEntity = new AxResultEntity();

        if (userinfo == null) {
            responseEntity.setState(false);
            responseEntity.setMsg("账号不存在");
        } else {

            /*记录登录成功或失败*/
            IpLog ipLog = new IpLog();
            ipLog.setIp(request.getRemoteAddr());
            ipLog.setLoginTime(new Date());
            ipLog.setUserName(userName.toLowerCase());
            ipLog.setUserType(userinfo.getUserType());
            ipLog.setUserinfoId(userinfo.getId());

            if (userinfo.getPassWord().toLowerCase().equals(passWord.toLowerCase())) {

                /*登陆成功,保存当前登陆的userinfo*/
                UserinfoContext.putUserinfo(userinfo);
                ipLog.setLoginState(IpLog.LOGINSTATE_SUCCESS);

                responseEntity.setState(true);
                responseEntity.setBody(userinfo);

            } else {

                ipLog.setLoginState(IpLog.LOGINSTATE_FAILD);
                responseEntity.setState(false);
                responseEntity.setMsg("账号或者密码错误");

            }
            ipLogMapper.insert(ipLog);
        }


        return responseEntity;

    }

    @Override
    public boolean hasAdmin() {

        return this.userinfoMapper.getCountByuserName(AxConst.ADMIN_NAME) > 0;

    }

    @Override
    public void createAdmin() {

        if (!hasAdmin()) {

            Userinfo userinfo = new Userinfo();
            userinfo.setUserName(AxConst.ADMIN_NAME);
            userinfo.setPassWord(AxConst.ADMIN_PASSWORD);
            userinfo.setUserType(Userinfo.USERTYPE_SYSTEM);
            this.userinfoMapper.insert(userinfo);

        }

    }
}
