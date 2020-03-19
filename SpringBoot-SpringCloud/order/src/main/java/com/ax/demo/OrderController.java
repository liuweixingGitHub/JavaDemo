package com.ax.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xing
 */
@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL = "http://cloud-payment-service";
    public static final String PAYMENT_URL = "http://localhost:8090";

    @Value("${server.port}")
    private String port;


    @Resource
    private RestTemplate restTemplate;

   @Autowired
    private OrderPaymentService orderPaymentService;

    @GetMapping(value = "/order/search")
    public Object search(Long id) {
        Map<Object, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("name", "订单");
        map.put("port", port);

        return map;
    }


    @GetMapping(value = "/order/payment")
    public Object order_payment(@RequestParam(value = "id") Long id) {
        System.out.println("order payment id = " + id);


        Map map = restTemplate.getForObject(PAYMENT_URL + "/payment/search" + "?id=" + id, Map.class);


        return map;
    }

    @GetMapping(value = "/order/payment/feign")
    public Object order_payment2(@RequestParam(value = "id") Long id) {
        System.out.println("order payment feign id = " + id);

        Map map = orderPaymentService.getOrderPayment(id);
        map.put("description", "利用feign调用");
        return map;
    }

}
