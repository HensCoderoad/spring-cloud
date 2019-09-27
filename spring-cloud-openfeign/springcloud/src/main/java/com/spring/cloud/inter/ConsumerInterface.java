package com.spring.cloud.inter;

import com.spring.cloud.entity.Person;
import com.spring.cloud.inter.impl.ConsumerImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : Hens
 * @date : 2019/9/27 9:22
 */
@FeignClient(value = "producer", fallback = ConsumerImpl.class)
public interface ConsumerInterface {

    @GetMapping("getPerson/{id}")
    public Person getPerson(@PathVariable(value = "id") int id);
}
