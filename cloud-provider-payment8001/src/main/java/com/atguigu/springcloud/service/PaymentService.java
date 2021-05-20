package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/18/0018-16:24
 */
public interface PaymentService {
    /**
     * create
     *
     * @param payment payment
     * @return int
     * @author sunxc50
     * @date 2021/05/20 21:19
     */
    int create(Payment payment);

    /**
     * getPaymentById
     *
     * @param id id
     * @return int
     * @author sunxc50
     * @date 2021/05/20 21:19
     */
    Payment getPaymentById(@Param("id") Long id);
}
