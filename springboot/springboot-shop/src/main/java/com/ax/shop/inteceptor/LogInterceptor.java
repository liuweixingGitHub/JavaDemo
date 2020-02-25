package com.ax.shop.inteceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 用于记录日志，在每次请求之前，打印请求的地址和参数，方便调试
*/

public class LogInterceptor extends HandlerInterceptorAdapter {

   /** 记录日志 */
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        StringBuilder sb = new StringBuilder();
//        String uri = request.getRequestURI();
//        sb.append("---------------> uri:").append(uri).append(" - ");
//
//        Enumeration<String> enums2 = request.getParameterNames();
//        while (enums2.hasMoreElements()) {
//            String key = enums2.nextElement();
//            sb.append("\"").append(key).append("\":").append(
//                    request.getParameter(key)).append(", ");
//        }
//        logger.info(sb.toString());

        return super.preHandle(request, response, handler);
    }
}
