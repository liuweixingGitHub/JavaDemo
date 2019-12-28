package com.ax.shop.security.service;

import com.ax.shop.mapper.IpLogMapper;
import com.ax.shop.mapper.UserinfoMapper;
import com.ax.shop.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    protected HttpServletRequest request;


    @Autowired
    private ILoginService loginService;

    @Autowired
    private IpLogMapper ipLogMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("UserDetailServiceImpl username = " + username);


        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        com.ax.shop.entity.Userinfo userinfo = loginService.getByUserName(username);

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_EMPLOYEE");
        grantedAuthorities.add(grantedAuthority);


        userinfo.setGrantedAuthorities(grantedAuthorities);
//        userinfo.setPassWord(new BCryptPasswordEncoder().encode(userinfo.getPassWord()));
        return userinfo;

//        return new User(userinfo.getUserName(), new BCryptPasswordEncoder().encode(userinfo.getPassWord()), grantedAuthorities);


//        //生成环境是查询数据库获取username的角色用于后续权限判断（如：张三 admin)
//        //这里不做数据库操作，给定假数据，有兴趣的人可以使内存模式。
//        if (username.equals("employee")) {
//            Employee employee = new Employee();
//            employee.setUsername("employee");
//            employee.setPassword("123456");
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_EMPLOYEE");
//            grantedAuthorities.add(grantedAuthority);
//            //创建一个用户，用于判断权限，请注意此用户名和方法参数中的username一致；BCryptPasswordEncoder是用来演示加密使用。
//            return new User(employee.getUsername(), new BCryptPasswordEncoder().encode(employee.getPassword()), grantedAuthorities);
//        }
//        if (username.equals("admin")) {
//            Admin admin = new Admin();
//            admin.setUsername("admin");
//            admin.setPassword("123456");
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
//            grantedAuthorities.add(grantedAuthority);
//            return new User(admin.getUsername(), new BCryptPasswordEncoder().encode(admin.getPassword()), grantedAuthorities);
//        }
//        else {
//            return null;
//        }


    }
}
