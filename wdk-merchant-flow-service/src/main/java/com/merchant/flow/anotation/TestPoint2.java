package com.merchant.flow.anotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestPoint2 {

    public String rule() default "";

    public String message() default "";


}
