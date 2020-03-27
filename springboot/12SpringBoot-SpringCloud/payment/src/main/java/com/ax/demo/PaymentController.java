package com.ax.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author xing
 */
@RestController
//@DefaultProperties(defaultFallback = ) 默认降级方法
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/search")
    public Map<String, Object> search(Long id) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("name", "支付");
        map.put("port", port);

        return map;
    }

    @GetMapping(value = "/payment/get/{id}")
    public Map<String, Object> get_id(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("name", "支付");
        map.put("port", port);

        return map;
    }


    @GetMapping(value = "/payment/lb/{id}")
    public Map<String, Object> lb_id(@PathVariable(value = "id") Long id) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("name", "支付");
        map.put("port", port);

        return map;
    }



    @GetMapping(value = "/payment/timeout")
    @HystrixCommand(fallbackMethod = "getOrderPaymentTimeoutFall", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,
                    value = "3000")
    })
    Map<String, Object> getOrderPaymentTimeout(@RequestParam(value = "id") Long id) throws InterruptedException {

        System.out.println("getOrderPaymentTimeout id = " + id);

        TimeUnit.SECONDS.sleep(id);

        Map<String, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("name", "支付");
        map.put("port", port);
        String currentThread = Thread.currentThread().getName();
        map.put("currentThread", currentThread);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        map.put("methodName", methodName);
        return map;

    }

    public Map<String, Object> getOrderPaymentTimeoutFall(@RequestParam(value = "id") Long id) {

        System.out.println("order payment hystrix fall id = " + id);

        Map<String, Object> map = new HashMap<>(16);
        map.put("id", id);
        map.put("name", "支付-链接超时");
        map.put("port", port);

        String currentThread = Thread.currentThread().getName();
        map.put("currentThread", currentThread);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        map.put("methodName", methodName);
        return map;
    }

}
