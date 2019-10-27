package com.shiro.jpa.dao;

import com.shiro.jpa.entity.ExceptionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExceptionLogDao extends JpaRepository<ExceptionLog ,Long>, JpaSpecificationExecutor<ExceptionLog> {
}
