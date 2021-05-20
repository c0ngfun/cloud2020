package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 代表我7001就是服务的注册中心
 *
 * @author sunxc
 * @version 1.0
 * // exclude ：启动时不启用 DataSource的自动配置检查
 * @date 2020/11/19 10:49
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }
}
