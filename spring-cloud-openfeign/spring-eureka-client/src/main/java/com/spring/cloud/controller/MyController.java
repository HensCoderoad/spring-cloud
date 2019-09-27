package com.spring.cloud.controller;


import com.spring.cloud.entity.Person;
import com.spring.cloud.inter.ConsumerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Hens
 * @date : 2019/9/25 16:20
 */
@RestController
public class MyController {

    @Autowired
    private ConsumerInterface consumerInterface;

    @GetMapping("person/{id}")
    public Person getPerson(@PathVariable int id){
        return consumerInterface.getPerson(id);
    }

}
