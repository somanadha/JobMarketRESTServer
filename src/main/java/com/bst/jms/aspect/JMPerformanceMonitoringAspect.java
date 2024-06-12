package com.bst.jms.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JMPerformanceMonitoringAspect {
    private static final Logger logger = LoggerFactory.getLogger(JMPerformanceMonitoringAspect.class);

    // Return_Type Class_Name.Method_Name(Arguments)
    @Around("execution(* com.bst.jms.repository.JMJobPostRepository.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint jointPoint) throws Throwable {

        long startTimeInMilli = System.currentTimeMillis();

        Object returningObject = jointPoint.proceed();

        long endTimeInMilli = System.currentTimeMillis();

        logger.info("Time Taken To Execute "+
                jointPoint.getSignature().getName()+ " :"
                + (endTimeInMilli - startTimeInMilli)
                + "(in milli seconds):");

        return returningObject;
    }
}
