package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunxc
 * @date 2020/11/22 12:39
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")   //feign接口+注解@FeignClient

public interface PaymentFeignService {
    /**
     * getPaymentById
     *
     * @param id id
     * @return com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment>
     * @author sunxc50
     * @date 2021/05/20 16:20
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * paymentFeignTimeout
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 16:20
     */
    @GetMapping(value = "payment/feign/timeout")
    String paymentFeignTimeout();
}
