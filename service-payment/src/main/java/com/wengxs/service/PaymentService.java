package com.wengxs.service;

import com.wengxs.entity.Payment;

public interface PaymentService {

    int save(Payment payment);

    Payment getById(Long id);
}
