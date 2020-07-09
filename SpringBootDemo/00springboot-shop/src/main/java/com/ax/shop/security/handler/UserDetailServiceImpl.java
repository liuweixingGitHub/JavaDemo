package com.ax.shop.security.handler;//package com.example.security.handler;
//
//
//import com.example.security.entity.Userinfo;
//import com.example.security.service.ILoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    protected HttpServletRequest request;
//
//
//    @Autowired
//    private ILoginService loginService;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        System.out.println("UserDetailServiceImpl username = " + username);
//
//
//        Userinfo userinfo = loginService.getByUserName(username);
//        if (userinfo == null){
//            throw new UsernameNotFoundException(username);
//        }
//
//        List<GrantedAuthority> authorityList = new ArrayList<>();
//
//        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_EMPLOYEE");
//        authorityList.add(authority);
//
//        userinfo.setGrantedAuthorities(authorityList);
//
//        return userinfo;
//
//    }
//}
