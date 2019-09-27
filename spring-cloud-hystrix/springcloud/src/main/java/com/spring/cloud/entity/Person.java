package com.spring.cloud.entity;

import java.util.Date;

/**
 * @author : Hens
 * @date : 2019/9/25 15:59
 */
public class Person {

    private String name;

    private Date birthday;

    public Person() {
    }

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
