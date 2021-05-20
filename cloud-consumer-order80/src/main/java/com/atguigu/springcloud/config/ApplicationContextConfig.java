package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description: ApplicationContextConfig
 * @projectname:cloud2020
 * @classname:ApplicationContextConfig
 * @author: sunxc
 * @date: 2020/11/18/0018-17:44
 * @version: 1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
   // @LoadBalanced   //使用@LoadBalanced  赋予RestTemplate 负载均衡能力  （默认轮询）    注销掉是为了写自己的负载均衡算法
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
