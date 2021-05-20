package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunxc
 * @date 2020/11/22/ 12:39
 */
@Configuration
public class FeignConfig {

    /**
     * feignLoggerLevel
     *
     * @return feign.Logger.Level
     * @author sunxc50
     * @date 2021/05/20 15:48
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
