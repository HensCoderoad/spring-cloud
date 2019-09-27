package com.spring.cloud.controller;

import com.spring.cloud.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : Hens
 * @date : 2019/9/25 16:04
 */
@RestController
public class PersonController {

    @GetMapping("getPerson")
    public Person getPerson(){
        return new Person("li",new Date());
    }
}
