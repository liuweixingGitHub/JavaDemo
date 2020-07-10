package com.ax.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    /*降级服务*/
    @GetMapping(value = "/order/payment/hystrix")
    public Object order_hystrix(@RequestParam(value = "id") Long id) {
        System.out.println("order payment hystrix id = " + id);

        Map map = orderPaymentService.getOrderPaymentTimeout(id);

        String currentThread = Thread.currentThread().getName();
        map.put("currentThread", currentThread);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        map.put("methodName", methodName);
        return map;
    }


    public Object order_hystrix_fall(Long id) {

        System.out.println("order payment hystrix fall id = " + id);

        Map map = new HashMap(16);
        String currentThread = Thread.currentThread().getName();
        map.put("currentThread", currentThread);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        map.put("methodName", methodName);
        return map;
    }

    /**
     * 降级服务,fenig 里面使用fallbakc方法,这里就需要一个注解就可以了
     */
    @GetMapping(value = "/order/payment/hystrix/timeout2/{id}")
    @HystrixCommand
    public Object order_hystrix2(@PathVariable(value = "id") Long id) {
        System.out.println("order payment hystrix id = " + id);

        Map<String, Object> map = orderPaymentService.getOrderPaymentTimeout(id);
        map.put("id", id);
        String currentThread = Thread.currentThread().getName();
        map.put("currentThread", currentThread);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        map.put("methodName", methodName);
        return map;
    }

    /**
     * 熔断,浏览器直接刷新,就能模拟模拟百分比错误请求
     */
    @GetMapping(value = "/order/payment/hystrix/breaker/{id}")
    @HystrixCommand(fallbackMethod = "order_hystrix_breaker_fall", commandProperties = {


            /*circuitBreaker.enabled  是否开启断路器*/
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,
                    value = "true"),

            /*circuitBreaker.requestVolumeThreshold 请求次数*/
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,
                    value = "10"),

            /*circuitBreaker.sleepWindowInMilliseconds  时间窗口期*/
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,
                    value = "10000"),

            /*circuitBreaker.errorThresholdPercentage  失败率多次跳闸 百分比的值*/
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,
                    value = "60"),

    })
    public Object order_hystrix_3(@PathVariable(value = "id") Long id) {
        System.out.println("order_hystrix_3 id = " + id);

        if (id < 0) {
            throw new RuntimeException("id 不能为负数");
        }

        Map<String, Object> map = orderPaymentService.getOrderPaymentTimeout(id);
        map.put("id", id);
        map.put("result", UUID.randomUUID().toString());
        return map;
    }


    public Object order_hystrix_breaker_fall(Long id) {

        Map map = new HashMap(16);
        map.put("id", id);
        map.put("error", "熔断开启");

        return map;
    }
}
