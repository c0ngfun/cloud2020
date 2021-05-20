package com.atguigu.com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @projectname:cloud2020
 * @classname:ReceiveMessageListenercontroller
 * @author: sunxc
 * @date: 2020/11/22/0022-17:04
 * @version: 1.0
 */

@Component
@EnableBinding(Sink.class)  //消费值 消费消息
public class ReceiveMessageListenercontroller {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，serverport: " + serverPort + "，接受到的消息：" + message.getPayload());
    }
}
