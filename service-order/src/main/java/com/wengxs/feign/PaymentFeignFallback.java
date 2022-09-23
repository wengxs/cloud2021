package com.wengxs.feign;

import com.wengxs.entity.Payment;
import com.wengxs.entity.R;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PaymentFeignFallback implements PaymentFeign {

    @Override
    public R<Payment> get(@PathVariable("id") Long id) {
        return new R<>(500, "服务降级");
    }
}
