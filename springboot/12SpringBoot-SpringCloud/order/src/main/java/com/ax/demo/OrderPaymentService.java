package com.ax.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
@FeignClient(value = "cloud-payment-service",url = "http://localhost:8090")
public interface OrderPaymentService {

    @GetMapping(value = "/payment/search")
        // 这里的是payment项目中的对应的接口
    Map<String, Object> getOrderPayment(@RequestParam(value = "id") Long id);
}
