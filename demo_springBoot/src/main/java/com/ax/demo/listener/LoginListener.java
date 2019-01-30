package com.ax.demo.listener;



import com.ax.demo.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoginListener  implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    private ILoginService loginService;
//
//    @Autowired
//    HttpServletRequest request;
//
//    @Autowired
//    HttpServletResponse response;

    public void onApplicationEvent(ContextRefreshedEvent event){

        System.out.println("监听tomcat启动>>");

//        loginService.createAdmin();

    }
}

//@Component
//public class LoginListener  implements HandlerInterceptor {
//
//    @Autowired
//    private ILoginService loginService;
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//
//        System.out.println("监听tomcat启动>>");
//
//        loginService.createAdmin();
//
//
//        HttpSession session = request.getSession();
//        Userinfo userinfo = (Userinfo) session.getAttribute(AXConst.USERINFO_IN_SESSION);
//        if (userinfo == null) {
//
//            String url = request.getContextPath() + "/login.html";
//
//            System.out.println("userinfo == null"+ "url="+url);
//
//            response.sendRedirect(url);
//
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        System.out.println("监听tomcat启动>>");
//
//        loginService.createAdmin();
//    }
//}


