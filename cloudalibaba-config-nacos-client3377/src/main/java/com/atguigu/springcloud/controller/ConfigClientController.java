package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * //@RefreshScope  支持Nacos的动态刷新功能   通过springcloud原生注解 @RefreshScope 实现配置自动更新
 *
 * @author sunxc
 * @date 2020-12-13
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    /**
     * getConfigInfo
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:34
     */
    @GetMapping("configclient/getconfiginfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
