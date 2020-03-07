package com.merchant.flow.anotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestPoint {

    String rule() default "";

    String message() default "123";

}
