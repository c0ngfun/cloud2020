package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * //@RestController  /*必须是这个注解，因为是模拟前后端分离的restful风格的请求，要求每个方法返回 json
 *
 * @author sunxc
 * @version 1.0
 * @date 2020/11/18 15:47
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {   //@RequestBody   不要忘记  否则插入数据库中是null
        int result = paymentService.create(payment);
        log.info("______********插入结果成功" + result);

        if (result > 0) {
            return new CommonResult(200, "插入成功serverport:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("______********查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败:id" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPamentLoadBalance() {
        return serverPort;
    }
}
