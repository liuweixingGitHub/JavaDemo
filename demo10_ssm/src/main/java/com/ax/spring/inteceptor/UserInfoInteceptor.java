package com.ax.spring.inteceptor;

import com.ax.spring.context.UserinfoContext;
import com.ax.spring.interceptor.RequiredLogin;
import com.ax.spring.util.AXTools.AXConst;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoInteceptor  extends HandlerInterceptorAdapter {
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
}
