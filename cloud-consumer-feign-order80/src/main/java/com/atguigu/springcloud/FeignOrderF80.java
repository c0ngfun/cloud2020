package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/21 11:48
 */
@SpringBootApplication
@EnableFeignClients // 使用feign 激活并开启

public class FeignOrderF80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderF80.class,args);
    }
}
