package com.bst.JobMarketRESTServer.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Return_Type Class_Name.Method_Name(Arguments)
    @Before("execution(* com.bst.JobMarketRESTServer.service.JobPostService.*(..)) || execution(* com.bst.JobMarketRESTServer.repository.JobPostRepository.*(..))")
    public void logBefore(JoinPoint jointPoint) {
        logger.info("Before Entering: " + jointPoint.getSignature().getName());
    }


    // Return_Type Class_Name.Method_Name(Arguments)
    @AfterThrowing("execution(* com.bst.JobMarketRESTServer.service.JobPostService.*(..)) || execution(* com.bst.JobMarketRESTServer.repository.JobPostRepository.*(..))")
    public void logAfterThrowing(JoinPoint jointPoint) {
        logger.info("After Throwing From:" + jointPoint.getSignature().getName());
    }

    // Return_Type Class_Name.Method_Name(Arguments)
    @AfterReturning("execution(* com.bst.JobMarketRESTServer.service.JobPostService.*(..)) || execution(* com.bst.JobMarketRESTServer.repository.JobPostRepository.*(..))")
    public void logAfterReturning(JoinPoint jointPoint) {
        logger.info("While Returning From:" + jointPoint.getSignature().getName());
    }

    // Return_Type Class_Name.Method_Name(Arguments)
    @After("execution(* com.bst.JobMarketRESTServer.service.JobPostService.*(..)) || execution(* com.bst.JobMarketRESTServer.repository.JobPostRepository.*(..))")
    public void logAfter(JoinPoint jointPoint) {
        logger.info("After Returning Successfully:" + jointPoint.getSignature().getName());
    }
}
