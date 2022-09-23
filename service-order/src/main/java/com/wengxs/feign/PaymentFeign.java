package com.wengxs.feign;

import com.wengxs.entity.Payment;
import com.wengxs.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "payment-service", fallbackFactory = PaymentFeignFallbackFactory.class)
public interface PaymentFeign {

    @GetMapping("/payment/get/{id}")
    R<Payment> get(@PathVariable("id") Long id);
}
