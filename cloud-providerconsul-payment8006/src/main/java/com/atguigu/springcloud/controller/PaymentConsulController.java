package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:PaymentConsulController
 * @author: sunxc
 * @date: 2020/11/20/0020-12:17
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private  String serverPort;

    @RequestMapping(value="/payment/consul")
    public String paymentConsul(){
        return  "springcloud-cosul-"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
