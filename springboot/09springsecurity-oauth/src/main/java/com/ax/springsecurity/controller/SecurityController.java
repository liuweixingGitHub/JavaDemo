package com.ax.springsecurity.controller;


import com.ax.springsecurity.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @RequestMapping("/code")
    public String code(String code) { // token =1 才能访问
        System.out.println("code = " + code);

        return "Hello,World!";
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


