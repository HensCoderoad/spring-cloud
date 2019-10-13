package com.rocketmq.consumer.controller;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : Hens
 * @date : 2019/10/13 12:16
 */
@RestController
public class SendMessageController {
    @Autowired
    DefaultMQProducer producer;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("email")
    public void sendMessage(String mail){
        try {
        String code = UUID.randomUUID().toString().substring(0,6);
        String sendMessage = mail + "&" + code;
        stringRedisTemplate.opsForValue().set(mail, code , 5 * 60 * 1000);
        Message message = new Message("TopicTest",sendMessage.getBytes(RemotingHelper.DEFAULT_CHARSET));
        producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping
    public String login(String email, String code){
        String s = stringRedisTemplate.opsForValue().get(email);
        return s;
    }
}
