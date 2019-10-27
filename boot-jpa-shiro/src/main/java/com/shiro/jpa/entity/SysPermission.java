package com.shiro.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "permission_t")
public class SysPermission implements Serializable {
    @Id
    @GeneratedValue
    private Integer pid;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_t", joinColumns = { @JoinColumn(name = "pid")},inverseJoinColumns = { @JoinColumn(name = "rid")})
    private Set<SysRole> roles;

//    @Override
//    public String toString() {
//        return "SysPermission{" +
//                "pid=" + pid +
//                ", name='" + name + '\'' +
//                ", roles=" + roles +
//                '}';
//    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }
}
