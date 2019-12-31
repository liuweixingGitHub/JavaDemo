package com.example.security.controller;


import com.example.security.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

@RestController
public class SecurityController {

    @RequestMapping("/login.html")
    public ModelAndView loginHTML() {

        return new ModelAndView("login");
    }

    @RequestMapping("/home.html")
    public ModelAndView homeHTML() {

        return new ModelAndView("home");
    }

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
    @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
//    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_MANAGER')")
    public String greeting3() {     // token =2 才能访问
        System.out.println("greeting2");
        return "Hello,Worl-33!";
    }

    @Autowired
    private ILoginService loginService;

    //@PreAuthorize可以用来控制一个方法是否能够被调用。
    @RequestMapping("/security2")
    public Object admin3() {

        System.out.println(" loginService.getById(1L); = " + loginService.getById(1L));
        return loginService.getById(1L);
    }


}


