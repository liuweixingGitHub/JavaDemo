package com.ax.demo.inteceptor;


import com.ax.demo.interceptor.RequiredLogin;
import com.ax.demo.util.axtools.AXConst;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInteceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("LoginInteceptor拦截器 >> preHandle");

        if (handler instanceof HandlerMethod) {

            HandlerMethod handlerMethod = (HandlerMethod) handler;


            RequiredLogin requiredLogin = handlerMethod.getMethodAnnotation(RequiredLogin.class);

             /*
                有自定义标签
              */
            if (requiredLogin != null){
                /*
                没有保存过userinfo信息
                 */
                if (request.getSession().getAttribute(AXConst.USERINFO_IN_SESSION) == null){

                    response.sendRedirect("/login.html");
                    return false;
                }
            }
        }

        return super.preHandle(request, response, handler);
    }


//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("LoginInteceptor >>"+"preHandle"+request);
//
//        return super.preHandle(request, response, handler);
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        super.postHandle(request, response, handler, modelAndView);
//        System.out.println("LoginInteceptor >>"+"postHandle"+request);
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        super.afterCompletion(request, response, handler, ex);
//        System.out.println("LoginInteceptor >>"+"postHandle"+response);
//    }
}
