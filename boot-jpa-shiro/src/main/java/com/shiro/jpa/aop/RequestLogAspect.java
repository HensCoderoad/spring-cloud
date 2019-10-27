package com.shiro.jpa.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shiro.jpa.annotations.Operation;
import com.shiro.jpa.dao.ExceptionLogDao;
import com.shiro.jpa.dao.RequestLogDao;
import com.shiro.jpa.entity.ExceptionLog;
import com.shiro.jpa.entity.RequestLog;


import com.shiro.jpa.utils.DateUtil;
import com.shiro.jpa.utils.RequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * aop切面类
 */
@Aspect
@Component
public class RequestLogAspect {

    private RequestLog requestLog = new RequestLog();
    private ExceptionLog exceptionLog = new ExceptionLog();
    private Long startTime;
    private Long returnTime;

    @Autowired
    private RequestLogDao requestLogDao;
    @Autowired
    private ExceptionLogDao exceptionLogDao;
    @Autowired
    private HttpServletRequest request;

    /**
     * 定义请求日志切入点
     * @param operation
     */
    @Pointcut(value = "@annotation(operation)")
    public void serviceStatistics(Operation operation){
    }

    /**
     * 前置通知
     * @param joinpoint
     * @param operation
     */
    @Before("serviceStatistics(operation)")
    public void doBefore(JoinPoint joinpoint, Operation operation){
        // 获取切入点参数
        Map<String, Object> joinPointInfo = RequestUtil.getJoinPointInfoMap(joinpoint);
        // 设置请求信息
        startTime = System.currentTimeMillis();
        requestLog.setStartTime(DateUtil.parse(startTime));
        requestLog.setIp(RequestUtil.getRequestIp(request));
        requestLog.setClasspath(joinPointInfo.get("classPath").toString());
        requestLog.setMethodName(joinPointInfo.get("methodName").toString());
        requestLog.setWay(request.getMethod());
        requestLog.setParam((String) joinPointInfo.get("paramMap"));
        requestLog.setType(RequestUtil.getRequestType(request));
        requestLog.setSessionId(request.getSession().getId());
        requestLog.setUrl(request.getRequestURL().toString());
        requestLog.setOperation(operation.value());
    }

    /**
     * 返回通知
     * @param operation
     * @param returnValue
     */
    @AfterReturning(value = "serviceStatistics(operation)", returning = "returnValue")
    public void doAfterReturning(Operation operation, Object returnValue){
        returnTime = System.currentTimeMillis();
        requestLog.setReturnTime(DateUtil.parse(returnTime));
        requestLog.setFinishTime(DateUtil.timeDifferLong(startTime, returnTime));
        requestLog.setReturnData(JSON.toJSONString(returnValue,SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
        // 保存请求日志数据
        requestLogDao.save(requestLog);
    }

    /**
     * 异常通知
     * @param operation
     * @param e
     */
    @AfterThrowing(value = "serviceStatistics(operation)", throwing = "e")
    public void doAfterThrowing(Operation operation, Throwable e){
        long happenTime = System.currentTimeMillis();
        exceptionLog.setHappenTime(DateUtil.parse(happenTime));
        exceptionLog.setExceptionJson(JSON.toJSONString(e,SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
        exceptionLog.setExceptionMessage(e.getMessage());
        exceptionLogDao.save(exceptionLog);
    }
}
