package com.utility.expence_tracker.infrastructure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRequestResponse {
    
    String value() default "";
    
    boolean logRequest() default true;
    
    boolean logResponse() default true;
    
    boolean logExecutionTime() default true;
}