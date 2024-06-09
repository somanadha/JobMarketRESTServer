package com.bst.JobMarketRESTServer.aspect;

import com.bst.JobMarketRESTServer.model.JobPost;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);

    // Return_Type Class_Name.Method_Name(Arguments)
    @Around("execution(* com.bst.JobMarketRESTServer.service.JobPostService.saveJobPost(..)) && args(jobPost)")
    public Object saveJobPost_ValidateArgument(ProceedingJoinPoint jointPoint, JobPost jobPost) throws Throwable {

        logger.info("JobPost Parameters Before Entering Into: "+
                jointPoint.getSignature().getName() +": "+jobPost.toString());

        var jobPostObjctArray = new Object[] {jobPost};

        Object returningObject = jointPoint.proceed(jobPostObjctArray);

        return returningObject;
    }
}
