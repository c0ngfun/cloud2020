package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author sunxc
 * @date 2020-11-26
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 读取配置文件中的支付提供者的url地址  //在yml里面写的提供者服务路径，  值为：http://nacos-provider
     */
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    /**
     * getPayment
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 22:00
     */
    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, String.class);
    }
}

