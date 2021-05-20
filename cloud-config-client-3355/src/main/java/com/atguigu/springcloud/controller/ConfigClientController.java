package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxc
 * @date 2020/11/22 12:39
 */
@RestController
@RefreshScope //实现刷新功能

public class ConfigClientController {

    /**
     * configInfo
     */
    @Value("${config.info}")
    private String configInfo;

    /**
     * getConfigInfo
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 15:44
     */
    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
