package com.rocketmq.consumer.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author : Hens
 * @date : 2019/10/13 12:11
 */
@SpringBootConfiguration
public class MQConfig {
    @Value("${mqgroup}")
    private String mqgroup;
    @Value("${mqurl}")
    private String mqurl;
    @Bean
    public DefaultMQProducer getDefaultMQProducer(){
        DefaultMQProducer producer = new DefaultMQProducer(mqgroup);
        producer.setNamesrvAddr(mqurl);
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return producer;
    }
}
