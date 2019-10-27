package com.shiro.jpa.dao;

import com.shiro.jpa.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RequestLogDao extends JpaRepository<RequestLog ,Long> ,JpaSpecificationExecutor<RequestLog> {
}
