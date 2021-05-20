package com.atguigu.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/21 15:03
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallbackServiceImpl.class)
public interface PaymentHystrixService {

    /**
     * paymentInfoOk
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:34
     */
    @GetMapping("/payment/hystrix/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    /**
     * paymentInfoTimeout
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:34
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeout(@PathVariable("id") Integer id);
}
