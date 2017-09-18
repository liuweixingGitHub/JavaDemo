package com.ax.spring.controller;


import com.alibaba.fastjson.JSONObject;
import com.ax.spring.context.UserinfoContext;
import com.ax.spring.domain.Person;
import com.ax.spring.domain.Userinfo;
import com.ax.spring.interceptor.RequiredLogin;
import com.ax.spring.service.ILoginService;
import com.ax.spring.service.IRegisterService;
import com.ax.spring.util.AXTools.AXResult;
import com.ax.spring.domain.User;
import com.ax.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestConteoller {

    @Autowired
    private IUserService userService;


    @Autowired
    private IRegisterService logininfoService;

    @Autowired
    private ILoginService loginService;

    @Autowired
    protected HttpServletRequest request;

    @RequestMapping(value="/400.do")
    @ResponseBody
    public ModelAndView error(String username, String password){

        JSONObject jsonObject = new JSONObject();
        try {

            Userinfo logininfo = this.loginService.login(username,password,request);

            System.out.println("logininfo = " + logininfo);

            jsonObject.put("result",true);
            jsonObject.put("userinfo",logininfo);

        }catch (RuntimeException e){
            jsonObject.put("result",true);
            jsonObject.put("mes",e.getMessage());
        }

        ModelAndView mView = new ModelAndView("400.jsp");

        mView.addObject("key",jsonObject);

        return mView;

    }









//    @RequestMapping(value="/regp")
//    @ResponseBody
//    public AXResult regP(LogininfoParameter logininfoParameter,@RequestParam(required=true)String id){
//
//        AXResult result = new  AXResult();
//        try {
//
//            this.logininfoService.register(logininfoParameter.getUsername(),logininfoParameter.getPassword());
//
//            result.setResult(true);
//            result.setMsg("注册成功");
//
//        }catch (RuntimeException e){
//
//            result.setResult(false);
//            result.setMsg(e.getMessage());
//        }
//        return result;
//    }



    @RequestMapping(value="/reg2")
    @ResponseBody
    public String reg2(String username,String password){

        System.out.println("reg"+username);

        return username+password;

    }


    @RequestMapping(value="/reg3")
    public ModelAndView reg3(String username, String password){

        ModelAndView mView = new ModelAndView();
        mView.addObject("key","填进去");
        mView.setViewName("home.jsp");
        return mView;
    }



    @RequestMapping(value="/hello")
    @ResponseBody
    public String hello(){

        System.out.println("HelloController");


        User user = userService.get(1L);

        List<User>  list = new ArrayList();
        list.add(user);

//        return  new AXResult(true,list).toJSONString();
        System.out.println( AXResult.errorMsg("代码"));
        System.out.println( ">>"+AXResult.succeeList(null));
        System.out.println( ">>"+AXResult.succeeList(list));
        return  AXResult.succeeList(list);


//        return "abc";
    }


//    @RequestMapping(value="/test",produces="application/json;charset=UTF-8")
    @RequestMapping(value="/test")
    @ResponseBody
    public String test(){



        List<Person> list = new ArrayList();

        Person person = new Person();
        person.setAge(10);
        person.setName("ppp");

        User user1 = new User();
        user1.setAge(11);
        user1.setName("name11");

        User user2 = new User();
        user2.setAge(12);
        user2.setName("中文名字12");

        User user3 = new User();
        user3.setAge(13);
        user3.setName("中文名字14");

        person.getList1().add(user1);
        person.getList1().add(user2);
        person.setUser2(user3);

        list.add(person);

//        str= JSON.toJSONString(list);
//
//        System.out.println(">>>"+str);


//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("list",list);
//
//        System.out.println(">>>"+jsonObject);
//
//        str = jsonObject.toJSONString();

//        return new AXResult(true,list).toJSONString();

        return AXResult.succeeList(list);
    }



    @RequestMapping("/hello2")
    public ModelAndView function1 ()  {

        System.out.println("demo1");

        ModelAndView mView = new ModelAndView();
        mView.addObject("key","123456");
        mView.setViewName("hello");
        return mView;

    }


    /*
     *采用spring提供的上传文件的方法 上传多个文件
     */
    @RequestMapping("/up")
    @ResponseBody
    public String  springUpload(HttpServletRequest request) throws Exception {
        System.out.println("上传文件........");

        List<String> list = new ArrayList();

        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());

        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            System.out.println("iter-->"+iter);



            while(iter.hasNext()){

                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null){
                    String path="/Users/moledeveloper/Desktop/"+file.getOriginalFilename();
                    System.out.println("path-->"+path);
                    //上传
                    file.transferTo(new File(path));
                    list.add(file.getOriginalFilename());
                }

            }

        }

        System.out.println("上传文件 成功");
        if (list.size()==1){
            String name = list.get(0);
            System.out.println("name = " + name);
//            return  new AXResult(true,name).toJSONString();
            return AXResult.succeeFileName(name);
//            return  JSON.toJSONString( new AXResult(true,name));
        }else {

//            return  new AXResult(true,list).toJSONString();
            return AXResult.succeeList(list);
        }

    }
}
