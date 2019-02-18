package com.ax.demo.inteceptor;

import com.ax.demo.interceptor.RequiredLogin;
import com.ax.demo.util.axtools.AxConst;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author axing
 */
@Component
public class LoginInteceptor extends BaseInteceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("LoginInteceptor拦截器 >> preHandle");

        if (handler instanceof HandlerMethod) {

            HandlerMethod handlerMethod = (HandlerMethod) handler;

            RequiredLogin requiredLogin = handlerMethod.getMethodAnnotation(RequiredLogin.class);

             /**是否有自定义标签*/
            if (requiredLogin != null){

                /**没有保存过userinfo信息*/
                if (request.getSession().getAttribute(AxConst.USERINFO_IN_SESSION) == null){

                    response.sendRedirect("/");
                    return false;
                }
            }
        }
        return super.preHandle(request, response, handler);
    }

}
