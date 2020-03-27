package com.ax.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/")
    public Object index(){
        Map<String, Object> map = new HashMap<>(16);
        map.put("name", "index");
        map.put("port", port);
        return map;
    }

}
