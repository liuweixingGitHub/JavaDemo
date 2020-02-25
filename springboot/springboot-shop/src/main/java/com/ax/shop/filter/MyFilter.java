package com.ax.shop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter和Interceptor的区别
 *
 * 1、Filter是基于函数回调（doFilter()方法）的，而Interceptor则是基于Java反射的（AOP思想）。
 *
 * 2、Filter依赖于Servlet容器，而Interceptor不依赖于Servlet容器。
 *
 * 3、Filter对几乎所有的请求起作用，而Interceptor只能对action请求起作用。
 *
 * 4、Interceptor可以访问Action的上下文，值栈里的对象，而Filter不能。
 *
 * 5、在action的生命周期里，Interceptor可以被多次调用，而Filter只能在容器初始化时调用一次。
 *
 * 6、Filter在过滤是只能对request和response进行操作，而interceptor可以对request、response、handler、modelAndView、exception进行操作。

 使用filter支持跨域资源访问
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("MyFilter == Filter只能在容器初始化时调用一次。");

        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

//        HttpServletResponse res = (HttpServletResponse) response;
//        res.setHeader("Access-Control-Allow-Origin", "*");
//        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
//        res.setHeader("Access-Control-Max-Age", "3600");
//        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, >Authorization");
//        res.setHeader("Access-Control-Expose-Headers", "Content-Disposition, Authorization-info, Stale");



////        使用Filter过滤器实现禁用缓存
//        response.setDateHeader("Expires", -1);
//        response.setHeader("Cache-Control", "no-cache");



        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
