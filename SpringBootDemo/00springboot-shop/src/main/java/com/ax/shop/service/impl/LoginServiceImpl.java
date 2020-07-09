package com.ax.shop.service.impl;


import com.ax.shop.context.UserinfoContext;
import com.ax.shop.entity.IpLog;
import com.ax.shop.entity.Userinfo;
import com.ax.shop.mapper.IpLogMapper;
import com.ax.shop.mapper.UserinfoMapper;
import com.ax.shop.service.ILoginService;
import com.ax.shop.util.axUtil.AxConst;
import com.ax.shop.util.axUtil.AxResultStateEnum;
import com.ax.shop.util.axUtil.AxResultEntity;
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
        ipLog.setUsername(username);


        Userinfo userinfo = this.userinfoMapper.getModelByusernameAndpassword(username, password);
        if (userinfo != null) {
            /*
            登陆成功,保存当前登陆的userinfo
             */
//            UserinfoContext.putUserinfo(userinfo);

//            ipLog.setUserType(userinfo.getUserType());
            ipLog.setUserinfoId(userinfo.getId());
            ipLog.setLoginState(IpLog.LOGINSTATE_SUCCESS);

            ipLogMapper.insert(ipLog);
        } else {
            ipLog.setLoginState(IpLog.LOGINSTATE_FAILD);

        }


        return userinfo;

    }

    @Override
    public Userinfo getByUserName(String username) {

        Userinfo userinfo = this.userinfoMapper.getByusername(username);

        return userinfo;

    }

    @Override
    public Userinfo getById(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);
    }


    @Override
    public Object loginState(String username, String password, HttpServletRequest request) {


        Userinfo userinfo = this.userinfoMapper.getByusername(username.toLowerCase());

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
            ipLog.setUsername(username.toLowerCase());
//            ipLog.setUserType(userinfo.getUserType());
            ipLog.setUserinfoId(userinfo.getId());

            if (userinfo.getPassword().toLowerCase().equals(password.toLowerCase())) {

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

        return this.userinfoMapper.getCountByusername(AxConst.ADMIN_NAME) > 0;

    }

    @Override
    public void createAdmin() {

        if (!hasAdmin()) {

            Userinfo userinfo = new Userinfo();
            userinfo.setUsername(AxConst.ADMIN_NAME);
            userinfo.setPassword(AxConst.ADMIN_PASSWORD);
//            userinfo.setUserType(Userinfo.USERTYPE_SYSTEM);
            this.userinfoMapper.insert(userinfo);

        }

    }
}
