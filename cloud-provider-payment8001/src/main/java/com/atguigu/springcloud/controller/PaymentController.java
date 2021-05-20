package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * // @RestController 必须是这个注解，因为是模拟前后端分离的restful风格的请求，要求每个方法返回 json
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

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * create
     *
     * @param payment payment
     * @return com.atguigu.springcloud.entities.CommonResult
     * @author sunxc50
     * @date 2021/05/20 21:14
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {   //@RequestBody   不要忘记  否则插入数据库中是null
        int result = paymentService.create(payment);
        log.info("______********插入结果成功" + result);

        if (result > 0) {
            return new CommonResult(200, "插入成功,serverport:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入失败" + serverPort, null);
        }
    }

    /**
     * getPaymentById
     *
     * @param id id
     * @return com.atguigu.springcloud.entities.CommonResult
     * @author sunxc50
     * @date 2021/05/20 21:15
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("______********查询结果：" + payment);

        if (null != payment) {
            return new CommonResult(200, "查询成功,serverPort" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败:id" + id, null);
        }
    }

    /**
     * discovery
     *
     * @return java.lang.Object
     * @author sunxc50
     * @date 2021/05/20 21:15
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****************" + element);
        }
        // 多个实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost()
                    + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * getPaymentLoadBalancer
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:16
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLoadBalancer() {
        return serverPort;
    }

    /**
     * 写一个故意暂服务
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:16
     */
    @GetMapping(value = "payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    /**
     * paymentZipKin
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:17
     */
    @GetMapping(value = "/payment/zipkin")
    public String paymentZipKin() {
        return "hi ,i 'am paymentzipkin server fall back，welcome to atguigu， o(n_n)o哈哈~";
    }
}
