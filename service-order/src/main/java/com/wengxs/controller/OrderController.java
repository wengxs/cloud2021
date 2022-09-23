package com.wengxs.controller;

import com.wengxs.entity.Payment;
import com.wengxs.entity.R;
import com.wengxs.feign.PaymentFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://payment-service";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private PaymentFeign paymentFeign;

    @GetMapping("/order/createPayment")
    public R<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, R.class);
    }

    @GetMapping("/order/getPayment/{id}")
    public R<Payment> getPayment(@PathVariable("id") Long id) {
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, R.class);
        return paymentFeign.get(id);
    }
}
