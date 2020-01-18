package com.ax.content.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {


    @RequestMapping("/code")
    public void code(HttpServletRequest request,HttpServletResponse response, String code) throws Exception { // token =1 才能访问
        System.out.println("code = " + code);
//        response.setHeader("code",code);
//        response.setHeader("grant_type","authorization_code");
//        response.sendRedirect("http://client:secret@localhost:8080/oauth/token");
        toHttp(code);


    }

    public  void toHttp(String code) throws Exception {
        // 创建Httpclient对象,相当于打开了浏览器
        CloseableHttpClient httpclient = HttpClients.createDefault();

        URIBuilder uriBuilder = new URIBuilder("http://client:secret@localhost:8080/oauth/token");

        uriBuilder.setParameter("code",code);
        uriBuilder.setParameter("grant_type","authorization_code");

        // 创建HttpGet请求，相当于在浏览器输入地址
        HttpPost httpPost = new HttpPost(uriBuilder.build());

        CloseableHttpResponse response = null;
        try {
            // 执行请求，相当于敲完地址后按下回车。获取响应
            response = httpclient.execute(httpPost);
            System.out.println(response.getStatusLine().getStatusCode());

            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应，获取数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        }catch (Exception e){
            System.out.println("e = " + e);
        }finally {
            if (response != null) {
                // 关闭资源
                System.out.println("返回值不空");
                response.close();
                return;
            }
            System.out.println("返回值空");
            // 关闭浏览器
            httpclient.close();
        }

    }



    @GetMapping("/")
    public Object home(){

        Map map = new HashMap();
        map.put("code",123);
        return map;
    }
    @GetMapping("/test")
    public Object test(){

        Map map = new HashMap();
        map.put("test","222");
        return map;
    }

    @RequestMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String greeting() { // token =1 才能访问
        return "ROLE_ADMIN";
    }

    @RequestMapping("/admin2")
    @Secured("ROLE_MANAGER")
    public String greeting2() {
        return "ROLE_MANAGER";
    }

}
