package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/22 23:46
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * getPayment
     *
     * @param id id
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 22:01
     */
    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry,serverPort: " + serverPort + "\t id" + id;
    }
}
