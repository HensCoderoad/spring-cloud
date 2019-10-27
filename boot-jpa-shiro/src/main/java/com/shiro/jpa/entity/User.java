package com.shiro.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_t")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long uid;

    private String username;

    private String password;

    private String salt;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "uid")}, inverseJoinColumns = { @JoinColumn(name = "rid")})
    private Set<SysRole> roles;

    public String getCredentialsSalt(){
        return username + salt + salt;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "uid=" + uid +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", salt='" + salt + '\'' +
//                ", roles=" + roles +
//                '}';
//    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }
}
