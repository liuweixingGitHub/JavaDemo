package com.ax.spring.listener;



import com.ax.spring.context.UserinfoContext;
import com.ax.spring.domain.Userinfo;
import com.ax.spring.service.ILoginService;
import com.ax.spring.util.AXTools.AXConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@Component
//public class LoginListener  implements ApplicationListener<ContextRefreshedEvent>{
//
//    @Autowired
//    private ILoginService loginService;

//    @Autowired
//    HttpServletRequest request;
//
//    @Autowired
//    HttpServletResponse response;

//    public void onApplicationEvent(ContextRefreshedEvent event){
//
//        System.out.println("监听tomcat启动>>");

//        HttpSession session = request.getSession();
//        Userinfo userinfo = (Userinfo) session.getAttribute(UserinfoContext.USERINFO_IN_SESSION);
//        if (userinfo == null) {
//            System.out.println("userinfo == null");

//            response.sendRedirect(request.getContextPath() + "/login.html");


//            try {
//                response.sendRedirect(request.getContextPath()+"login.html");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        }else {
//            System.out.println("userinfo != null");
//        }

//        loginService.createAdmin();
//    }
//}

//@Component
public class LoginListener  implements HandlerInterceptor {

    @Autowired
    private ILoginService loginService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        System.out.println("监听tomcat启动>>");

        loginService.createAdmin();


        HttpSession session = request.getSession();
        Userinfo userinfo = (Userinfo) session.getAttribute(AXConst.USERINFO_IN_SESSION);
        if (userinfo == null) {

            String url = request.getContextPath() + "/login.html";

            System.out.println("userinfo == null"+ "url="+url);

            response.sendRedirect(url);

            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("监听tomcat启动>>");

        loginService.createAdmin();
    }
}


