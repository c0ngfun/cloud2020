package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon 核心组件IRule接口（七大负载均衡算法）    IRule：根据特定算法从服务列表中选取一个要访问的服务
 *
 * @author sunxc
 * @date 2020/11/20 23:11
 */
@Configuration

public class MyRule {

    @Bean
    public IRule myRule() {
        //负载均衡规则定义为随机
        return new RandomRule();
    }
}
