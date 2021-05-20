package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/21 14:30
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * paymentInfoOk
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:07
     */
    @GetMapping("/payment/hystrix/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info("paymentInfo_OKKKKOKKK:" + result);
        return result;
    }

    /**
     * paymentInfoTimeout
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:08
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String timeOutResult = paymentHystrixService.paymentInfoTimeout(id);
        log.info("paymentInfo_timeout" + timeOutResult);
        return timeOutResult;
    }

    /**
     * 服务熔断
     *
     * @param id ID
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:08
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentCircuitBreaker(id);
    }
}
