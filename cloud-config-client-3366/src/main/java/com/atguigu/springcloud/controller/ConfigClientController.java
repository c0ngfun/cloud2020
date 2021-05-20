package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunxc
 * @date 2020/11/22/0022-12:39
 */
@RestController
@RefreshScope //实现刷新功能

public class ConfigClientController {

    /**
     * server.port
     */
    @Value("${server.port}")
    private String serverPort;
    /**
     * config.info
     */
    @Value("${config.info}")
    private String configInfo;

    /**
     * configInfo
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 15:46
     */
    @GetMapping("/configInfo")
    public String configInfo() {
        return serverPort + "," + "config info:" + configInfo;

    }
}
