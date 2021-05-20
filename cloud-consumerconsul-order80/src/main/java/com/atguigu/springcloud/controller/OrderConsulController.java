package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/20 17:06
 */
@RestController
@Slf4j
public class OrderConsulController {
    /**
     * // public static final String PAYMENT_URL = "http://localhost:8001";   //这里地址写死了
     * // 重点是这里，改成 提供者在Eureka 上的名称，而且无需写端口号
     */
    public static final String PAYMENT_URL = "http://consul-provider-service";
    @Resource
    private RestTemplate restTemplate;

    /**
     * paymentConsulInfo
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 18:12
     */
    @GetMapping("/consumer/consul")
    public String paymentConsulInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }
}
