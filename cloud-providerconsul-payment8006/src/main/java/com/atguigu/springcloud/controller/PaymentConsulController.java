package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/20 12:17
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * paymentConsul
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:26
     */
    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud-cosul-" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
