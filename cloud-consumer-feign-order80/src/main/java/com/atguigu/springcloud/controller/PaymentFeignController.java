package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunxc
 * @date 2020/11/22 12:39
 */
@RestController
@Slf4j
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * getPaymentById
     *
     * @param id id
     * @return com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment>
     * @author sunxc50
     * @date 2021/05/20 16:06
     */
    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    /**
     * paymentFeignTimeout
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 16:06
     */
    @GetMapping(value = "consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        //openfeign的底层是ribbon ，客户端一般默认等待一秒
        return paymentFeignService.paymentFeignTimeout();
    }
}
