package com.shiro.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role_t")
public class SysRole implements Serializable {

    @Id
    @GeneratedValue
    private Integer rid;

    private String role;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission_t", joinColumns = {@JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "pid")})
    private Set<SysPermission> permissions;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "rid")}, inverseJoinColumns = {@JoinColumn(name = "uid")})
    private Set<User> users;

//    @Override
//    public String toString() {
//        return "SysRole{" +
//                "rid=" + rid +
//                ", role='" + role + '\'' +
//                ", permissions=" + permissions +
//                ", users=" + users +
//                '}';
//    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
