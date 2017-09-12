package com.ax.spring.service;


import com.ax.spring.domain.Userinfo;
import com.ax.spring.mapper.UserinfoMapper;
import com.ax.spring.util.AXConst;
import com.ax.spring.util.UserinfoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements ILoginService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    public Userinfo login(String username, String password){

        Userinfo userinfo = this.userinfoMapper.getModelByUsernameAndPassword(username,password);

        if (userinfo != null){
            /*
            登陆成功,保存当前登陆的userinfo
             */
            UserinfoContext.putUserinfo(userinfo);
            return userinfo;

        }else {

            throw  new  RuntimeException("账号密码错误");

        }

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
