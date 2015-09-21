package com.mokona.core;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(FIELD)
@Retention(RUNTIME)
public @interface Element {

    String className() default "";
    String cssSelector() default "";
    String id() default "";
    String linkText() default "";
    String name() default "";
    String partialLinkText() default "";
    String tagName() default "";
    String xpath() default "";

}
