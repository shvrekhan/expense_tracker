package com.utility.expence_tracker.infrastructure.aspect;

import com.utility.expence_tracker.infrastructure.annotation.LogRepositoryOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Aspect
@Component
@Slf4j
public class RepositoryLoggingAspect {

    @Around("@annotation(logRepositoryOperation)")
    public Object logRepositoryOperation(ProceedingJoinPoint joinPoint, LogRepositoryOperation logRepositoryOperation) throws Throwable {
        
        String methodName = joinPoint.getSignature().getName();
        String operation = logRepositoryOperation.operation().isEmpty() ? methodName : logRepositoryOperation.operation();
        
        Object result = joinPoint.proceed();
        
        // Handle Mono
        if (result instanceof Mono) {
            return ((Mono<?>) result)
                .doOnSuccess(data -> {
                    if (logRepositoryOperation.logSuccess()) {
                        log.info("REPO_SUCCESS - {} - Data: {}", operation, data != null ? data.getClass().getSimpleName() : "null");
                    }
                })
                .doOnError(error -> {
                    if (logRepositoryOperation.logError()) {
                        log.error("REPO_ERROR - {} - Error: {}", operation, error.getMessage());
                    }
                });
        }
        
        // Handle Flux
        if (result instanceof Flux) {
            return ((Flux<?>) result)
                .doOnNext(data -> {
                    if (logRepositoryOperation.logSuccess()) {
                        log.info("REPO_SUCCESS - {} - Item: {}", operation, data.getClass().getSimpleName());
                    }
                })
                .doOnError(error -> {
                    if (logRepositoryOperation.logError()) {
                        log.error("REPO_ERROR - {} - Error: {}", operation, error.getMessage());
                    }
                });
        }
        
        return result;
    }
}