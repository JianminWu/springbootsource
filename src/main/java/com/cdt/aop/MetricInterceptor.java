package com.cdt.aop;

import com.cdt.annotation.CountMetric;
import com.cdt.metrics.MetricUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author: wujianmin
 * @Date: 2019/11/12 16:12
 * @Function:
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class MetricInterceptor {
    @Pointcut("execution(public * com.cdt.controller..*.*(..))")
    public void metricLog(){

    }

    @Before("metricLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        
//        log.info("url={}",request.getRequestURL());
//        //method
//        log.info("method = {}",request.getMethod());
//        //ip
//        log.info("ip = {}",request.getRemoteAddr());
//        //类方法
//        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
//        //参数
//        log.info("args = {}",joinPoint.getArgs());
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        if(method.isAnnotationPresent(CountMetric.class)){
//            MetricUtils.getCountMetric().mark();
//        }
    }
//@Around("metricLog()")
//    @After("metricLog()")
//    public void doAfter(JoinPoint joinPoint) throws Throwable{
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // url
//
////        log.info("url={}",request.getRequestURL());
////        //method
////        log.info("method = {}",request.getMethod());
////        //ip
////        log.info("ip = {}",request.getRemoteAddr());
////        //类方法
////        log.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
////        //参数
////        log.info("args = {}",joinPoint.getArgs());
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        if(method.isAnnotationPresent(CountMetric.class)){
//            MetricUtils.getCountMetric().mark();
//        }
//    }
}
