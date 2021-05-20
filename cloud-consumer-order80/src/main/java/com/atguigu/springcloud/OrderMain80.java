package com.atguigu.springcloud;

import com.atguigu.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * //消费者 实现ribbon负载均衡，自定义负载均衡规则myRule      --默认是轮询算法
 * //@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRule.class)
 *
 * @author sunxc
 * @version 1.0
 * @date 2020/11/18 17:16
 */
@SpringBootApplication
@EnableEurekaClient

public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
