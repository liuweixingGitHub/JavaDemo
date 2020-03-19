package com.ax.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xing
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/search")
    public Map<String, Object> search(Long id){
        Map<String, Object> map = new HashMap<>(16);
        map.put("id",id);
        map.put("name","支付");
        map.put("port",port);


        return map;
    }
}
