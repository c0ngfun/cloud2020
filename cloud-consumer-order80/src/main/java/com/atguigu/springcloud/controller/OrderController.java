package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author sunxc
 * @date 2020/11/18 17:20
 */
@RestController
@Slf4j
public class OrderController {
     /*
      * public static final String PAYMENT_URL = "http://localhost:8001";   //这里地址写死了
      重点是这里，改成 提供者在Eureka 上的名称，而且无需写端口号
      */
    /**
     * 这里地址写死了
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * create
     *
     * @param payment payment
     * @return com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment>
     * @author sunxc50
     * @date 2021/05/20 16:28
     */
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    /**
     * getPayment
     *
     * @param id id
     * @return com.atguigu.springcloud.entities.CommonResult<com.atguigu.springcloud.entities.Payment>
     * @author sunxc50
     * @date 2021/05/20 16:29
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * getPaymentLoadBalance
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 16:30
     */
    @GetMapping(value = "consumer/payment/lb")
    public String getPaymentLoadBalance() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "payment/lb", String.class);
    }

    /**
     * paymentZipkin
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 16:31
     */
    @GetMapping(value = "consumer/payment/zipkin")
    public String paymentZipkin() {
        return restTemplate.getForObject("http://localhost:8001/" + "payment/zipkin/", String.class);
    }
}
