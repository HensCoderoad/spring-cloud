package com.shiro.jpa.service;


import com.shiro.jpa.dao.UserDao;
import com.shiro.jpa.entity.User;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUserByName(String username){
        return userDao.findByUsername(username);
    }

    public void saveUser(User user){
        userDao.save(user);
    }
}
