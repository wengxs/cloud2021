package com.wengxs.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wengxs.entity.Payment;
import com.wengxs.entity.R;
import com.wengxs.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @PostMapping("/payment/create")
    public R create(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("插入结果：{}", result);
        if (result > 0) {
            return new R(200, "插入成功", payment);
        }
        return new R(500, "插入失败");
    }

    @Value("${timeout}")
    private Long timeout;

    @GetMapping("/payment/get/{id}")
//    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
    public R<Payment> get(@PathVariable("id") Long id) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment = paymentService.getById(id);
        log.info("查询结果：{}", payment);
        if (payment != null) {
            return new R<>(200, "查询成功" + port, payment);
        }
        return new R<>(500, "查询失败");
    }

    public R<Payment> fallbackMethod(Long id) {
        return new R<>(500, "查询失败" + id);
    }
}
