package com.utility.expence_tracker.infrastructure.aspect;


import com.utility.expence_tracker.infrastructure.annotation.LogRequestResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Aspect
@Component
@Slf4j
public class RequestResponseLoggingAspect {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Around("@annotation(logRequestResponse)")
    public Object logRequestResponse(ProceedingJoinPoint joinPoint, LogRequestResponse logRequestResponse) throws Throwable {
        
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        
        long startTime = System.currentTimeMillis();
        
        if (logRequestResponse.logRequest()) {
            Object[] args = joinPoint.getArgs();
            log.info("REQUEST - {}.{} - Args: {}", className, methodName, formatArgs(args));
        }
        
        Object result = null;
        Exception exception = null;
        
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            long executionTime = System.currentTimeMillis() - startTime;
            
            // Log Response
            if (logRequestResponse.logResponse()) {
                if (exception != null) {
                    log.error("RESPONSE - {}.{} - ERROR: {} - Time: {}ms", 
                        className, methodName, exception.getMessage(), executionTime);
                } else {
                    log.info("RESPONSE - {}.{} - Result: {} - Time: {}ms", 
                        className, methodName, formatResult(result), executionTime);
                }
            }
            
            // Log Execution Time
            if (logRequestResponse.logExecutionTime()) {
                log.info("EXECUTION_TIME - {}.{} - {}ms", className, methodName, executionTime);
            }
        }
    }
    
    private String formatArgs(Object[] args) {
        try {
            return objectMapper.writeValueAsString(args);
        } catch (Exception e) {
            return "Unable to serialize args";
        }
    }
    
    private String formatResult(Object result) {
        try {
            return objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            return "Unable to serialize result";
        }
    }
}