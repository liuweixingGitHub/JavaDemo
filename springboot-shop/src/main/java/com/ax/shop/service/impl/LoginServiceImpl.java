package com.ax.shop.service.impl;


import com.ax.shop.context.UserinfoContext;
import com.ax.shop.entity.IpLog;
import com.ax.shop.entity.Userinfo;
import com.ax.shop.mapper.IpLogMapper;
import com.ax.shop.mapper.UserinfoMapper;
import com.ax.shop.service.ILoginService;
import com.ax.shop.util.axtools.AxConst;
import com.ax.shop.util.axtools.AxResultStateEnum;
import com.ax.shop.util.axtools.AxResultEntity;
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
//            UserinfoContext.putUserinfo(userinfo);

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
    public Userinfo getByUserName(String userName) {


        Userinfo userinfo = this.userinfoMapper.getByuserName(userName);

        return userinfo;

    }



    @Override
    public Object loginState(String userName, String passWord, HttpServletRequest request) {


        Userinfo userinfo = this.userinfoMapper.getByuserName(userName.toLowerCase());

        System.out.println("userinfo = " + userinfo);


        AxResultEntity<Userinfo> responseEntity = new AxResultEntity();

        if (userinfo == null) {
            responseEntity.setStateEnum(AxResultStateEnum.SUCCESS);
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

                /**登陆成功,保存当前登陆的userinfo*/
                UserinfoContext.putUserinfo(userinfo);
                ipLog.setLoginState(IpLog.LOGINSTATE_SUCCESS);

                responseEntity.setStateEnum(AxResultStateEnum.SUCCESS);
                responseEntity.setBody(userinfo);

            } else {

                ipLog.setLoginState(IpLog.LOGINSTATE_FAILD);
                responseEntity.setStateEnum(AxResultStateEnum.INVALID);
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
