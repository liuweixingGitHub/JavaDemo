package com.ax.shop.controller;

import com.ax.shop.dto.LoginDto;
import com.ax.shop.service.ILoginService;
import com.ax.shop.util.axtools.AxResultStateEnum;
import com.ax.shop.util.axtools.AxResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author axing
 */
@Api(description = "用户接口")
@RestController
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;

    @ApiOperation(value = "登录请求", notes = "返回json数据")
    @RequestMapping(value = "/login.do")
    @ResponseBody
    public Object login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {

        System.out.println("username = " + username);

        Object object = this.loginService.loginState(username, password, this.request);

        System.out.println("object = " + object);

        return object;


    }

    @GetMapping(value = "/login22.do")
    public Object login22(@Validated LoginDto loginEntity) {

        Map<String, Object> map = new HashMap();
        map.put("getUsername", loginEntity.getUsername());
        map.put("getPassword", loginEntity.getPassword());
        return map;
    }


    @GetMapping(value = "/login2.do")
    @ResponseBody
    public Object login2() {

        AxResultEntity<List<String>> object = new AxResultEntity<>();
        object.setStateEnum(AxResultStateEnum.SUCCESS);
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
        object.setStateEnum(AxResultStateEnum.SUCCESS);
        object.setMsg("eee");
        object.setBody(list);

        return object;

    }

    /**
     * jsp 页面可以直接取值,默认是请求转发 forward:
     * ${result}
     */
    @ApiOperation(value = "登录页面", notes = "进入home页面")
    @RequestMapping(value = "/home.page")
    private ModelAndView homePage() {
        return new ModelAndView("home");

    }


    /**
     * 重定向
     **/

    @RequestMapping(value = "/loginPage1")
    @ResponseBody
    public Object loginPage1(@RequestParam(value = "name") String name) {

        System.out.println("name = " + name);

        Map map = new HashMap();
        map.put("name", "收到:" + name);
        return map;
    }

    @RequestMapping(value = "/loginPage2")
    @ResponseBody
    public Object loginPage2(@RequestParam(value = "name") String name) {

        System.out.println("name = " + name);

        return "收到:" + name;
    }

    @RequestMapping("/loginPage3")
    public String loginPage3(@RequestParam(value = "name", required = false) String name,
                             RedirectAttributes redirectAttributes,
                             HttpServletResponse response) throws Exception {
        System.out.println("name = " + name);
        //页面传参
        redirectAttributes.addFlashAttribute("userName", name);
        //url传参
        redirectAttributes.addAttribute("name", name);
        return "redirect:/loginPage1";

    }

    @RequestMapping("/loginPage4")
    public void loginPage4(@RequestParam(value = "name", required = false) String name,
                           HttpServletResponse response) throws Exception {
        System.out.println("name = " + name);

        response.sendRedirect("/loginPage1?name=" + name);

    }

}
