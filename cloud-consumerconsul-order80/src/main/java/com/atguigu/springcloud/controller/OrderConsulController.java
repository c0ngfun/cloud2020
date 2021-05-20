package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:OrderConsulController
 * @author: sunxc
 * @date: 2020/11/20/0020-17:06
 * @version: 1.0
 */
@RestController
@Slf4j
public class OrderConsulController {
    // public static final String PAYMENT_URL = "http://localhost:8001";   //这里地址写死了
    // 重点是这里，改成 提供者在Eureka 上的名称，而且无需写端口号
    public static final String PAYMENT_URL = "http://consul-provider-service";   //这里地址写死了
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String paymentConsulInfo() {
        String forObject = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return forObject;
    }
}
