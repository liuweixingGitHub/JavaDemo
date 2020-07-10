package com.ax.noweb;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String sayHi(){
        System.out.println("hi......");
        return "hi 123";
    }

}
