package com.spring.cloud.inter;

import com.spring.cloud.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Hens
 * @date : 2019/9/27 9:22
 */
@FeignClient("producer")
public interface ConsumerInterface {

    @GetMapping("getPerson")
    public Person getPerson();
}
