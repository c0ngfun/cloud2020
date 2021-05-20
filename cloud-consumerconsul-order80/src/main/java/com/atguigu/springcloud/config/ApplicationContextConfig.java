package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/18 17:44
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * //使用@LoadBalanced  赋予RestTemplate 负载均衡能力   （轮询）
     *
     * @return org.springframework.web.client.RestTemplate
     * @author sunxc50
     * @date 2021/05/20 18:11
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
