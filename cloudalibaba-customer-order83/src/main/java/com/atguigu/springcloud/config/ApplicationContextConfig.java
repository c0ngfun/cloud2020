package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:ApplicationContextConfig
 * @author: sunxc
 * @date: 2020/11/23/0023-0:07
 * @version: 1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
//    resttemplate结合ribbon 要加 @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

