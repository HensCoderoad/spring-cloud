package com.shiro.jpa.controller;

import com.shiro.jpa.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authc")
public class AuthcController {

    @GetMapping("index")
    public Object index(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute("user");
        return user.toString();
    }

    @GetMapping("admin")
    public Object admin(){
        return "Welcome Admin";
    }

    @GetMapping("removable")
    public Object removable(){
        return "Welcome removable";
    }

    @GetMapping("renewable")
    public Object renewable(){
        return "Welcome renewable";
    }

}
