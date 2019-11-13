package com.ax.demo.controller;

import com.ax.demo.entity.LoginEntity;
import com.ax.demo.entity.valid.PasswordGroup;
import com.ax.demo.entity.User;
import com.ax.demo.entity.valid.UsernameGroup;
import com.ax.demo.entity.valid.ValidList;
import com.ax.demo.interceptor.UserLoginToken;
import com.ax.demo.service.HttpClientService;
import com.ax.demo.service.impl.RedisService;
import com.ax.demo.util.axtools.AxReslutMessage;
import com.ax.demo.util.axtools.AxResultEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    RedisService redisService;

    @Autowired
    HttpClientService httpClientService;


    @RequestMapping(value = "/test1.do")
    public AxResultEntity testdo() {

        AxResultEntity<List<String>> axResultEntity = new AxResultEntity();

        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("Baaa");

        axResultEntity.setBody(list);
        axResultEntity.setState(true);
        axResultEntity.setMessage(AxReslutMessage.INVALID);

        return axResultEntity;

    }


    @RequestMapping(value = "/doRedis.do")
    public void doRedis() {

        redisService.set("key_redis_nane", "jim");

    }


    @RequestMapping(value = "/getRedis.do")
    public Object getRedis() {

        return redisService.get("key_redis_nane");

    }

    @RequestMapping(value = "/toHttp.do")
    public Object toHttp() {
//        String url = "http://www.suning.com/";
        String url = "http://localhost:8080/getIpLog.do?id=88";

//        String url = "http://www.baidu.com/";
        return httpClientService.getClient(url, null, Object.class);


    }


    @RequestMapping("/path/{id}")
    public Integer testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable:" + id);
        return id;
    }


    @ApiOperation(value = "RestGet", notes = "返回json数据")
    @GetMapping(value = "/restGet.do/{id}")
    @ResponseBody
    public ResponseEntity<String> RestGet(@RequestParam(value = "name") String name,
                                          @PathVariable("id") Integer id) {
        System.out.println("name = " + name);
        System.out.println("id = " + id);

        String spittle = "成功";
        HttpStatus status = spittle != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;

        return new ResponseEntity<String>(spittle, status);


    }

    @ApiOperation(value = "/restPost", notes = "返回json数据")
    @PostMapping(value = "/restPost.do")
    @ResponseBody
    public Object restPost(@RequestParam(value = "name") String name) {
        System.out.println("name = " + name);
        return name + "RestPos";

    }

    @DeleteMapping(value = "/restDelete.do")
    @ResponseBody
    public Object restDelete(@RequestParam(value = "name") String name) {
        System.out.println("name = " + name);
        return name + "RestDelete";

    }


    @PutMapping(value = "/restPut.do")
    @ResponseBody
    public Object restPut(@RequestParam(value = "name") String name) {
        System.out.println("name = " + name);
        return name + "RestPut";

    }

    /**
     * Put 请求参数模型不要用 @RequestBody
     *
     * @param user
     * @return
     */
    @PutMapping(value = "/restPut2.do")
    @ResponseBody
    public Object restPut2(User user) {

        System.out.println("user = " + user);
        return user;

    }

    @RequestMapping(value = "/testList.do")
    public void listParam(@RequestBody List<String> list, String name) {

        System.out.println("list = " + list);
        System.out.println("name = " + name);
    }

    @PostMapping(value = "/jwt.do")
    public String jwtTest() {

        return "JWT成功";
    }

    @PostMapping(value = "/jwt2.do")
    @UserLoginToken
    public String jwtTest2() {

        return "JWT成功";
    }


    @GetMapping(value = "/test22.do")
    public Object login22(@Validated({UsernameGroup.class,PasswordGroup.class}) LoginEntity loginEntity) {
        Map<String, Object> map = new HashMap();
        map.put("getUsername", loginEntity.getUsername());
        map.put("getPassword", loginEntity.getPassword());
        return map;
    }

    @GetMapping(value = "/test23.do")
    public Object login23(@Validated({UsernameGroup.class}) LoginEntity loginEntity) {
        Map<String, Object> map = new HashMap();
        map.put("getUsername", loginEntity.getUsername());
        map.put("getPassword", loginEntity.getPassword());
        return map;
    }

    @GetMapping(value = "/test24.do")
    public Object login24(@Validated({PasswordGroup.class}) LoginEntity loginEntity) {
        Map<String, Object> map = new HashMap();
        map.put("getUsername", loginEntity.getUsername());
        map.put("getPassword", loginEntity.getPassword());
        return map;
    }

    /**
     * 验证 list 必须要自定义一个list
     * @param loginEntityList
     * @return
     */
    @PostMapping(value = "/test25.do")
    public Object login25(@RequestBody @Validated({UsernameGroup.class, PasswordGroup.class}) ValidList<LoginEntity> loginEntityList) {

        loginEntityList.forEach(loginEntity ->
                System.out.println("loginEntity = " + loginEntity)
        );

        return "AA";
    }

}
