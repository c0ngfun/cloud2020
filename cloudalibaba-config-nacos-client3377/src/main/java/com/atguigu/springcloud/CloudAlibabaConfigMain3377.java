package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 进入bin目录，打开dos窗口，执行startup命令启动它。可访问 ：
 * 【 http://192.168.101.105:8848/nacos/index.html】地址，默认账号密码都是nacos
 *
 * @author sunxc
 * @date 2020-11-30
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class CloudAlibabaConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaConfigMain3377.class, args);
    }
}
