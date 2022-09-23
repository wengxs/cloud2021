package com.wengxs.feign;

import com.wengxs.entity.Payment;
import com.wengxs.entity.R;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PaymentFeignFallbackFactory implements FallbackFactory<PaymentFeign> {

    @Override
    public PaymentFeign create(Throwable cause) {
        return new PaymentFeign() {
            @Override
            public R<Payment> get(Long id) {
                return new R<>(500, "服务降级2");
            }
        };
    }
}
