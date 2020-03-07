package com.merchant.flow.anotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Aspect
public class TestPointAspect2 {

    @Pointcut("@annotation(com.merchant.flow.anotation.TestPoint2)")
    public void test() {}

    @Around("test()")
    public void zhiRu(ProceedingJoinPoint joinPoint) {

        try {
            Object[] args = joinPoint.getArgs();
            MethodSignature signature = (MethodSignature)joinPoint.getSignature();
            TestPoint2 annotation = signature.getMethod().getAnnotation(TestPoint2.class);
            String rule = annotation.rule();
            String[] rules = rule.split("\\.");
            String rule1 = rules[0];
            String[] parameterNames = signature.getParameterNames();

            int index = 0;
            for (String parameterName : parameterNames) {
                if (parameterName.equals(rule1)) {
                    if (rules.length == 1) {
                        args[index] = "__test_"+args[index];
                        joinPoint.proceed(joinPoint.getArgs());
                    } else {
                        Object parentObj = null;
                        Object object = args[index];
                        Field field = null;
                        for (int i = 1; i < rules.length; i++) {
                            parentObj = object;
                            String rule2 = rules[i];
                            field = object.getClass().getDeclaredField(rule2);
                            field.setAccessible(true);
                            object = field.get(object);
                        }
                        field.set(parentObj,"__test_"+object);
                        joinPoint.proceed(joinPoint.getArgs());
                    }
                    break;
                }
                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


    }

}
