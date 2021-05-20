package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/22 19:23
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamMqMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8803.class, args);
    }
}
