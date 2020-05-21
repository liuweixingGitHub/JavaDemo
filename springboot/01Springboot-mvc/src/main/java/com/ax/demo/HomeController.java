package com.ax.demo;

import com.ax.demo.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Api 用在类上，说明该类的作用。可以标记一个Controller类做为swagger 文档资源，使用方式：
 *
 * @Api(value = "/user", description = "Operations about user")
 */
@Api(value = "首页", tags = {"首页所有接口"})
@RestController
public class HomeController {
/**
 * ApiOperation：用在方法上，说明方法的作用，每一个url资源的定义,使用方式：
 */
    /**
     * PageInfo 含有页面信息
     */
    @ApiOperation(
            value = "首页.do",
            notes = "首页.donotes")
    @GetMapping(value = "/home.do")
    public Object ipLogPageInfo() {

        System.out.println("home.do");

        Map<String, Object> map = new HashMap<>();
        map.put("home", "首页");
        map.put("date", new Date());

        String nullStr = new String();

        map.put("null_key", nullStr);

        String className = Thread.currentThread().getStackTrace()[1].getClassName();//调用的类名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();//调用的方法名
        int lineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();//调用的行数

        map.put("className", className);
        map.put("methodName", methodName);
        map.put("lineNumber", lineNumber);

        return map;

    }

    @ApiOperation(value = "编辑公告", notes = "编辑公告notes")
    @PostMapping(value = "/edit")
    public Student edit(
            @ApiParam(name = "bis_key", value = "公告key", required = true) String bisKey,
            @ApiParam(name = "title", value = "公告标题", required = true) @RequestParam String title,
            @ApiParam(name = "content", value = "公告内容", required = true) String content) {

        return new Student();
    }

    @ApiOperation(value = "编辑公告", notes = "编辑公告notes")
    @PostMapping(value = "/edit2")
    public List<Student> edit2(
            @ApiParam(name = "bis_key", value = "公告key", required = true) String bisKey,
            @ApiParam(name = "title", value = "公告标题", required = true) @RequestParam String title,
            @ApiParam(name = "content", value = "公告内容", required = true) String content) {

      List<Student> list = new ArrayList<>();
      list.add(new Student());


        return list;
    }


    @RequestMapping(value = "/home.page")
    public Object ipLogPageInfo1() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = {"/", "/hi", "/index.html"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");

        System.out.println(" request.getRemotePort() = " + request.getServerPort());
        System.out.println("port = " + port);
        /// request.getServerPort()取值Nginx端口 ,要是负载均衡取 yaml端口
//        modelAndView.addObject("port",request.getServerPort());
        modelAndView.addObject("port", port);
        return modelAndView;

    }

    @Autowired
    ExcelService excelService;

    @RequestMapping(value = "/excel")
    public void excel(HttpServletResponse response) throws Exception {

        excelService.exportExcel(response);

    }


    @RequestMapping(value = "/sleep")
    public Object do2(@RequestParam(value = "time") long time) throws InterruptedException {

        Thread.sleep(time * 1000);

//        TimeUnit.SECONDS.sleep(time);

        System.out.println("time = " + time);

        Map<String, Object> map = new HashMap<>();
        map.put("home", "首页");
        return map;

    }


    @RequestMapping(value = "/video")
    public Object video() {

        ModelAndView modelAndView = new ModelAndView("videoPlay");
        modelAndView.addObject("title", "小猪佩奇");

        String name = "jm.mkv";
//        String name = "v0200f930000bpajn9hevctlh37upcj0.MP4";

        String videoPath = "http://127.0.0.1:8091/images/" + name;

        modelAndView.addObject("path", videoPath);


        return modelAndView;

    }

}
