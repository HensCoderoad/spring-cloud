package com.rocketmq.producer.listener;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/10/13 12:25
 */
@Component
public class MessageListenerConcurrentlyImpl implements MessageListenerConcurrently {
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {

        byte[] body = list.get(0).getBody();
        String email = new String(body);
        String[] split = email.split("&");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("15915106210@163.com");
        message.setTo(split[0]);
        message.setSubject("验证码");
        message.setText("您的验证码为" + split[1]);
        javaMailSender.send(message);
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
