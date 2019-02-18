package com.ax.study.all.service.impl;

import com.ax.study.db.entity.Userinfo;
import com.ax.study.db.mapper.UserinfoMapper;
import com.ax.study.all.service.IRegisterService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author axing
 */
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private UserinfoMapper userinfoMapper;


    @Override
    public boolean register(String username, String password, int userType) {

        int count = this.userinfoMapper.getCountByuserName(username);
        MD5Encoder.encode(password.getBytes());

        if (count <= 0) {
            Userinfo userinfo = new Userinfo();
            userinfo.setUserName(username);
            /**password 加密密码*/
            /* String psw_md5 = DigestUtils.md5DigestAsHex(password.getBytes());*/
            userinfo.setPassWord(password);
            userinfo.setUserType(userType);
            int insert = this.userinfoMapper.insert(userinfo);

            return insert > 0;

        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {

        int count = this.userinfoMapper.getCountByuserName(username);

        System.out.println("count = " + count);

        return count > 0;
    }


}
