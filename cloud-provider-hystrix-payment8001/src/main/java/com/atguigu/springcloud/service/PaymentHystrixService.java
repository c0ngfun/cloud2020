package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:PaymentHystrixService
 * @author: sunxc
 * @date: 2020/11/21/0021-14:25
 * @version: 1.0
 */
@Service
public class PaymentHystrixService {


//    ======服务降级

    /**
     * 可以正常访问的方法
     *
     * @param id
     * @return
     */
    public String paymentinfo_Ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_OK，id:" + id;
    }

    /**
     * 超时访问的方法
     */
    @HystrixCommand(fallbackMethod = "paymentinfo_TimeoutHandler", commandProperties = {
            //设置峰值，超过 3 （3000ms）秒，就会调用兜底方法,三秒以内走正常的方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentinfo_Timeout(Integer id) {
        int interTime = 2;
        try {
            TimeUnit.SECONDS.sleep(interTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // int i= 10/0;
        return "线程池：" + Thread.currentThread().getName() + "--paymentInfo_Timeout，id:" + id + "耗时" + "秒钟--";
    }

    //兜底方法，根据上述配置，程序内发生异常、或者运行超时，都会执行该兜底方法
    public String paymentinfo_TimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "--paymentinfo_TimeoutHandler，8001系统忙，请稍后再试，id:" + id + "\t" + "秒钟--" + "o(╥﹏╥)o";
    }


//  =====服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  // 失败率达到多少后跳闸
            //整体意思：10秒内 10次请求，有6次失败，就跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        //模拟发生异常
        if (id < 0) {
            throw new RuntimeException("*****id，不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能为负数，请稍后再试....";
    }
}
