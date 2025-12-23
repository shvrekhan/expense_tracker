package com.utility.expence_tracker.infrastructure.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRepositoryOperation {
    
    String operation() default "";
    
    boolean logSuccess() default true;
    
    boolean logError() default true;
}