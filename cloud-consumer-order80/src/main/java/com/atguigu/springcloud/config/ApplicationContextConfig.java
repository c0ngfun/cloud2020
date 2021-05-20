package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * //@LoadBalanced //使用@LoadBalanced  赋予RestTemplate 负载均衡能力
 * （默认轮询）    注销掉是为了写自己的负载均衡算法
 *
 * @author sunxc
 * @version 1.0
 * @date 2020/11/18/ 17:44
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
