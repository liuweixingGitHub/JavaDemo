package com.ax.demo.controller;

import com.ax.demo.interceptor.RequiredLogin;
import com.ax.demo.service.ILoginService;
import com.ax.demo.util.axtools.AxResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author axing
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public Object login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {

        System.out.println("username = " + username);

        Object axResultMap = this.loginService.loginState(username, password, this.request);

        System.out.println("axResultMap = " + axResultMap);

        return axResultMap;

    }


    @RequestMapping(value = "/login2.do")
    @ResponseBody
    public Object login2() {

        AxResultEntity<List<String>> object = new AxResultEntity<>();
        object.setState(true);
        object.setMsg("uuuuudddddd");

        List<String> list = new ArrayList<>();
        list.add("B");
        object.setBody(list);

        return object;

    }

    @RequestMapping(value = "/login3.do")
    @ResponseBody
    public Object login3() {

        List<String> list = new LinkedList<>();
        list.add("B");

        AxResultEntity<List<String>> object = new AxResultEntity<>();
        object.setState(true);
        object.setMsg("eee");
        object.setBody(list);

        return object;

    }

    /**
     * jsp 页面可以直接取值,默认是请求转发 forward:
     * ${result}
     */
    @RequestMapping(value = "/home.page")
    @RequiredLogin
    private ModelAndView homePage() {
        return new ModelAndView("home");

    }


    /**重定向**/

    @RequestMapping(value="/loginPage1")
    @ResponseBody
    public Object loginPage1(@RequestParam(value="name") String name) {

        System.out.println("name = " + name);

        Map map = new HashMap();
        map.put("name","收到:"+name);
        return map;
    }

    @RequestMapping(value="/loginPage2")
    @ResponseBody
    public Object loginPage2(@RequestParam(value="name") String name) {

        System.out.println("name = " + name);

        return "收到:"+name;
    }

    @RequestMapping("/loginPage3")
    public String loginPage3(@RequestParam(value="name", required=false ) String name,
                                 RedirectAttributes redirectAttributes,
                                 HttpServletResponse response)  throws Exception{
        System.out.println("name = " + name);
        //页面传参
        redirectAttributes.addFlashAttribute("userName", name);
        //url传参
        redirectAttributes.addAttribute("name", name);
        return "redirect:/loginPage1";

    }
    @RequestMapping("/loginPage4")
    public void loginPage4(@RequestParam(value="name", required=false ) String name,
                           HttpServletResponse response)  throws Exception{
        System.out.println("name = " + name);

        response.sendRedirect("/loginPage1?name="+name);

    }

}
