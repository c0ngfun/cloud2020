package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:PaymentService
 * @author: sunxc
 * @date: 2020/11/18/0018-16:24
 * @version: 1.0
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
