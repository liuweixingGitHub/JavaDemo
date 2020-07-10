package com.ax.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentFallbackService implements OrderPaymentService {


    @Override
    public Map<String, Object> getOrderPayment(Long id) {
        Map map = new HashMap();
        map.put("fall", "失败getOrderPayment");
        return map;
    }

    @Override
    public Map<String, Object> getOrderPaymentTimeout(Long id) {
        Map map = new HashMap();
        map.put("fall", "失败 getOrderPaymentTimeout");
        return map;
    }
}
