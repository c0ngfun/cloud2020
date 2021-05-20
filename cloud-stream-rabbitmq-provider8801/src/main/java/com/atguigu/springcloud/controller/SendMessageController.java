package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunxc
 * @version 1.0
 * @date 2020/11/22/0022-16:47
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    /**
     * sendMessage
     *
     * @return java.lang.String
     * @author sunxc50
     * @date 2021/05/20 21:31
     */
    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
