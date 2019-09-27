package com.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.entity.Person;
import com.spring.cloud.inter.ConsumerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author : Hens
 * @date : 2019/9/25 16:20
 */
@RestController
public class MyController {
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private LoadBalancerClient loadBalancer;
    @Autowired
    private ConsumerInterface consumerInterface;

    @GetMapping("person")
    @HystrixCommand(fallbackMethod = "defaultMsg")
    public Person getPerson(){
        return consumerInterface.getPerson();
    }

    public Person defaultMsg(){
        return new Person();
    }
//    @GetMapping("person")
//    public Person getPerson(){
//        ServiceInstance serviceInstance = loadBalancer.choose("producer");
////        List<ServiceInstance> instances = discoveryClient.getInstances("controller");
////
////        ServiceInstance serviceInstance = instances.get(0);
//        String host = serviceInstance.getHost();
//        System.out.println(host);
//        int port = serviceInstance.getPort();
//        System.out.println(port);
////        restTemplate.getForEntity()
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("http://").append(host).append(":").append(port).append("/getPerson");
//        Person person = restTemplate.getForObject(stringBuffer.toString(), Person.class);
//        return person;
//    }

//    @GetMapping("user")
//    public void getUser(){
//        ServiceInstance offerinfo = loadBalancer.choose("offerinfo");
//        int port = offerinfo.getPort();
//        String host = offerinfo.getHost();
//        System.out.println(port);
//    }
}
