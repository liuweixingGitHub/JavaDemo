package com.ax.shop.security.controller;


import com.ax.shop.entity.Userinfo;
import com.ax.shop.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecurityController {


    @RequestMapping("/admin/p")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @Secured("ROLE_ADMIN")
//    @RolesAllowed("ROLE_ADMIN")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Secured("ROLE_ADMIN")
    public String greeting() { // token =1 才能访问
        return "Hello,World!";
    }

    @RequestMapping("/admin/p2")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
//    @RolesAllowed("ROLE_MANAGER")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @Secured("ROLE_MANAGER")
    public String greeting2() {     // token =2 才能访问
        System.out.println("greeting2");
        return "Hello,Worl22222!";
    }

    @RequestMapping("/admin/p3")
//    @PreAuthorize("hasRole('ROLE_MANAGER')")
//    @RolesAllowed("ROLE_MANAGER")
//    @PreAuthorize("hasRole('ROLE_ADMIN,ROLE_MANAGER')")
    @Secured({ "ROLE_ADMIN", "ROLE_MANAGER" })
//    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_MANAGER')")
    public String greeting3() {     // token =2 才能访问
        System.out.println("greeting2");
        return "Hello,Worl-33!";
    }

    @Autowired
    private IUserinfoService userinfoService;


    //@PreAuthorize可以用来控制一个方法是否能够被调用。
    @RequestMapping("/security2")
    public Object admin3() {

        return userinfoService.selectUserWithRelo(1L);
    }


}


