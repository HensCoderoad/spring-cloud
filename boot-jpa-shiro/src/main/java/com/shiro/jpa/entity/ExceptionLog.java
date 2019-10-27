package com.shiro.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 异常记录
 */
@Entity
@Table(name = "t_exception_log")
public class ExceptionLog implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private String exceptionJson;

    private String exceptionMessage;
    @Temporal(TemporalType.TIMESTAMP)
    private Date happenTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExceptionJson() {
        return exceptionJson;
    }

    public void setExceptionJson(String exceptionJson) {
        this.exceptionJson = exceptionJson;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }
}
