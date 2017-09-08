package com.ax.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.ax.spring.domain.Userinfo;
import com.ax.spring.service.ILoginService;
import com.ax.spring.util.JsonView;
import com.ax.spring.util.UserinfoContext;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController extends BaseController {



    @Autowired
    private ILoginService loginService;

    @RequestMapping(value="/login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(required = true) String username, @RequestParam(required = true) String password){


        String userAgent = this.request.getHeader("user-agent");
        System.out.println("userAgent = " + userAgent);

        Map<String,Object> map = new HashMap<String, Object>();

        try {

            Userinfo userinfo = this.loginService.login(username,password);
            map.put("result",true);
            map.put("userinfo",userinfo);

            System.out.println(">>"+UserinfoContext.getCurrent());

        }catch (RuntimeException e){
            map.put("result",false);
            map.put("mes",e.getMessage());
        }
        return map;

    }


    @RequestMapping(value="/login2")

    public ModelAndView login2(@RequestParam(required=true)String username, @RequestParam(required=true)String password, Model model) {

        ModelAndView mView = new ModelAndView("home.jsp");

        JSONObject jsonObject = new JSONObject();

        try {

            Userinfo logininfo = this.loginService.login(username, password);

            System.out.println("logininfo = " + logininfo);

            jsonObject.put("result", true);
            jsonObject.put("userinfo", logininfo);

//            model.setList(userService.getUsers(model));
            //web端登陆

//            if(true)
//            {
//                mView.addObject("key",jsonObject);
//
//                return mView;
//            }
            //APP端登陆
//            else
//            {
                 mView.setViewName("app.jsp");
                mView.addObject("key",jsonObject);
//                return JsonView.Render(mView, response);
                JsonView.Render(mView, response);
                return  mView;
//            }

        } catch (RuntimeException e) {
            jsonObject.put("result", true);
            jsonObject.put("mes", e.getMessage());
            return mView;
        }







//        JSONObject jsonObject = new JSONObject();
//        try {
//
//            Userinfo logininfo = this.loginService.login(username, password);
//
//            System.out.println("logininfo = " + logininfo);
//
//            jsonObject.put("result", true);
//            jsonObject.put("userinfo", logininfo);
//
//        } catch (RuntimeException e) {
//            jsonObject.put("result", true);
//            jsonObject.put("mes", e.getMessage());
//        }
//
//
//        if ("html".equals(type)){
//            ModelAndView mView = new ModelAndView("home.jsp");
//
//            mView.addObject("key",jsonObject);
//
//            return mView;
//    }else {
//            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
//            mav.addObject("key",jsonObject);
//            return mav;
//
//        }



//        Map<String,Object> map = new HashMap<String, Object>();
//
//        try {
//
//            Userinfo logininfo = this.loginService.login(username,password);
//            System.out.println("logininfo = " + logininfo);
//            map.put("result",true);
//            map.put("userinfo",logininfo);
//
//        }catch (RuntimeException e){
//            map.put("result",false);
//            map.put("mes",e.getMessage());
//        }
//
//        ModelAndView mView = new ModelAndView("home.jsp",map);
//
//
//        return mView;

    }



}
