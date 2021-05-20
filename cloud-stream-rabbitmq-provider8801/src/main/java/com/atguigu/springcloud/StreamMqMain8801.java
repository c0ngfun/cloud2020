package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/22 16:34
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamMqMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8801.class, args);
    }
}
