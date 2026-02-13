package com.example.customAnnotation.Custom.Annotations.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogsExecutionsAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogsExecutionsAspect.class);

    @Around("@annotation(logExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, LogsExecutionsTime logExecutionTime) throws Throwable {

        long start = System.currentTimeMillis();
        long executionTime = System.currentTimeMillis() - start;

        //actual method call
        Object proceed = joinPoint.proceed();

        String description = logExecutionTime.value().isEmpty() ? joinPoint.getSignature().getName() : logExecutionTime.value();
        // logic based on the log level
        String logMessage = "{} executed in {} ms";
        if ("DEBUG".equals(logExecutionTime.level())) {
            logger.debug(logMessage, description, executionTime);
        } else {
            logger.info(logMessage, description, executionTime);
        }




        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        System.out.println("My custom annotations called");
        return proceed;
    }
}
