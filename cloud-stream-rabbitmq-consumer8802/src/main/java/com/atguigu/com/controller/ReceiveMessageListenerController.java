package com.atguigu.com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * //@EnableBinding(Sink.class)  //消费值 消费消息
 *
 * @author sunxc
 * @version 1.0
 * @date 2020/11/22 17:04
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * @param message message
     * @author sunxc50
     * @date 2021/05/20 21:28
     */
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号，serverport: " + serverPort + "，接受到的消息：" + message.getPayload());
    }
}
