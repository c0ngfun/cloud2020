package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:FeignOrderF80
 * @author: sunxc
 * @date: 2020/11/21/0021-11:48
 * @version: 1.0
 */
@SpringBootApplication
@EnableFeignClients // 使用feign 激活并开启
public class FeignOrderF80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderF80.class,args);
    }
}
