package com.spring.cloud.controller;

import com.spring.cloud.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : Hens
 * @date : 2019/9/25 16:04
 */
@RestController
public class PersonController {

    @GetMapping("getPerson/{id}")
    public Person getPerson(@PathVariable int id){
        if(id == 1){
//            try {
//                Thread.sleep(3000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            int i = 10 / 0;
        }
        return new Person("li",new Date());
    }
}
