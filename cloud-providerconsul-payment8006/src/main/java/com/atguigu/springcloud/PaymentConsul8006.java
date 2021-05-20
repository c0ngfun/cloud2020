package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author sunxc
 * @date 2020/11/20 10:30
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PaymentConsul8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsul8006.class,args);
    }
}

