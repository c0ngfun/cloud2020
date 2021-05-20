package com.atguigu.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/22 17:01
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamMqMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqMain8802.class, args);
    }
}
