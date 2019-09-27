package com.spring.cloud.inter.impl;

import com.spring.cloud.entity.Person;
import com.spring.cloud.inter.ConsumerInterface;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : Hens
 * @date : 2019/9/27 22:03
 */
@Component
public class ConsumerImpl implements ConsumerInterface {
    @Override
    public Person getPerson(int id) {
        return new Person("无此id",new Date());
    }
}
