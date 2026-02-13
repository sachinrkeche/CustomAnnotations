package com.example.customAnnotation.Custom.Annotations.AOP;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogsExecutionsTime {
    String value() default "";

    String description() default "";

    String name() default "";

    String level() default "INFO";
}
