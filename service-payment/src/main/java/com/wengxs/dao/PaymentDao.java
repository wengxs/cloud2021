package com.wengxs.dao;

import com.wengxs.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int insert(Payment payment);

    Payment selectById(@Param("id") Long id);
}
