package com.ax.spring.controller;


import com.ax.spring.interceptor.RequiredLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/account",method = RequestMethod.GET)
public class AccountController  extends BaseController {


}
