package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * PaymentDao
 *
 * @author sunxc50
 * @date 2021/05/20 21:18
 */
@Mapper
public interface PaymentDao {
    /**
     * create
     *
     * @param payment payment
     * @return int
     * @author sunxc50
     * @date 2021/05/20 21:18
     */
    int create(Payment payment);

    /**
     * getPaymentById
     *
     * @param id id
     * @return com.atguigu.springcloud.entities.Payment
     * @author sunxc50
     * @date 2021/05/20 21:18
     */
    Payment getPaymentById(@Param("id") Long id);
}
