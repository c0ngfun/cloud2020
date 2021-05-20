package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/23 0:07
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * resttemplate结合ribbon 要加 @LoadBalanced
     *
     * @return org.springframework.web.client.RestTemplate
     * @author sunxc50
     * @date 2021/05/20 21:36
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

