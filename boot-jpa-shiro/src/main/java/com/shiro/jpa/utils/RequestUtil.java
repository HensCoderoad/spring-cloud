package com.shiro.jpa.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import javassist.*;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * aop工具类
 */
public class RequestUtil {
    /**
     * 获取请求ip
     * @param request
     * @return
     */
    public static String getRequestIp(HttpServletRequest request){
        if(request == null){

        }
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        final String[] arr = ip.split(",");
        for (final String str : arr){
            if(!"unknown".equalsIgnoreCase(str)){
                ip = str;
                break;
            }
        }
        return ip;
    }

    /**
     * 获取请求方式：普通请求 ajax请求
     * @param request
     * @return
     */
    public static Integer getRequestType(HttpServletRequest request){
        if(request == null){

        }
        String xRequestWith = request.getHeader("X-Requeted-With");
        return xRequestWith == null?1:2;
    }

    /**
     * 获取切入点方法信息
     * @param joinPoint
     * @return
     */
    public static Map<String, Object> getJoinPointInfoMap(JoinPoint joinPoint){
        Map<String, Object> joinPointInfo = new HashMap<>(16);
        String classPath = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        joinPointInfo.put("classPath",classPath);
        joinPointInfo.put("methodName",methodName);
        Class<?> clazz = null;
        CtMethod ctMethod = null;
        LocalVariableAttribute attribute = null;
        int length = 0;
        int pos = 0;

        try {
            clazz = Class.forName(classPath);
            String clazzName = clazz.getName();
            ClassPool pool = ClassPool.getDefault();
            ClassClassPath classClassPath = new ClassClassPath(clazz);
            pool.insertClassPath(classClassPath);
            CtClass ctClass = pool.get(clazzName);
            ctMethod = ctClass.getDeclaredMethod(methodName);
            MethodInfo methodInfo = ctMethod.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            attribute = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            if(attribute == null){
                return joinPointInfo;
            }
            length = ctMethod.getParameterTypes().length;
            pos = Modifier.isStatic(ctMethod.getModifiers())?0:1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> paramMap = new HashMap<>(16);
        Object[] paramsArgsValues = joinPoint.getArgs();
        String[] paramsArgsNames = new String[length];
        for (int i = 0;i<length;i++){
            paramsArgsNames[i] = attribute.variableName(i + pos);
            String paramsArgsName = attribute.variableName(i + pos);
            if(paramsArgsName.equalsIgnoreCase("request") ||
                    paramsArgsName.equalsIgnoreCase("response") ||
                    paramsArgsName.equalsIgnoreCase("session")){
                break;
            }
            Object paramsArgsValue = paramsArgsValues[i];
            paramMap.put(paramsArgsName, paramsArgsValue);
        }
        joinPointInfo.put("paramMap", JSON.toJSONString(paramMap,SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
        return joinPointInfo;
    }
}
