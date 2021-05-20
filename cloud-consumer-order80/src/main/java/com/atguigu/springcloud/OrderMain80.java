package com.atguigu.springcloud;

import com.atguigu.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:OrderMain80
 * @author: sunxc
 * @date: 2020/11/18/0018-17:16
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//消费者 实现ribbon负载均衡，自定义负载均衡规则myrule      --默认是轮询算法
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
