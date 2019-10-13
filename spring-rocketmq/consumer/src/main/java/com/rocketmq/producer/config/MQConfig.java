package com.rocketmq.producer.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author : Hens
 * @date : 2019/10/13 12:23
 */
@SpringBootConfiguration
public class MQConfig {
    @Value("${mqgroup}")
    private String mqgroup;
    @Value("${mqurl}")
    private String mqurl;
    @Autowired
    private MessageListenerConcurrently messageListenerConcurrently;
    @Bean
    public DefaultMQPushConsumer defaultMQPushConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(mqgroup);
        consumer.setNamesrvAddr(mqurl);
        try {
            consumer.subscribe("TopicTest", "*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        consumer.registerMessageListener(messageListenerConcurrently);

        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return consumer;
    }

}
