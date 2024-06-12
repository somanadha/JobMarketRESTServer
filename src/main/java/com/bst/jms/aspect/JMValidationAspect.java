package com.bst.jms.aspect;

import com.bst.jms.model.JMJobPost;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JMValidationAspect {
    private static final Logger logger = LoggerFactory.getLogger(JMValidationAspect.class);

    // Return_Type Class_Name.Method_Name(Arguments)
    @Around("execution(* com.bst.jms.service.JMJobPostService.saveJobPost(..)) && args(jobPost)")
    public Object saveJobPost_ValidateArgument(ProceedingJoinPoint jointPoint, JMJobPost jobPost) throws Throwable {

        logger.info("JMJobPost Parameters Before Entering Into: "+
                jointPoint.getSignature().getName() +": "+jobPost.toString());

        var jobPostObjctArray = new Object[] {jobPost};

        Object returningObject = jointPoint.proceed(jobPostObjctArray);

        return returningObject;
    }
}
