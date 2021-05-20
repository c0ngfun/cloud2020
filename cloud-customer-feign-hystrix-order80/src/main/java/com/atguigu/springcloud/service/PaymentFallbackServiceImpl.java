package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:PaymentFallbackService
 * @author: sunxc
 * @date: 2020/11/21/0021-16:30
 * @version: 1.0
 */
@Component
public class PaymentFallbackServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService paymentInfo_Timeout,o(╥﹏╥)o";
    }
}
