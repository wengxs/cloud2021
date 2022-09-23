package com.wengxs.service.impl;

import com.wengxs.dao.PaymentDao;
import com.wengxs.entity.Payment;
import com.wengxs.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int save(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.selectById(id);
    }
}
