package com.ax.spring.listener;



import com.ax.spring.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoginListener  implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private ILoginService loginService;



    public void onApplicationEvent(ContextRefreshedEvent event) {

        System.out.println("监听tomcat启动>>");

        loginService.createAdmin();
    }
}


