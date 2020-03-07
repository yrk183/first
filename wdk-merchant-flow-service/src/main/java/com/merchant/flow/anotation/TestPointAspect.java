package com.merchant.flow.anotation;


import com.merchant.flow.domain.StudentDO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
@Aspect
public class TestPointAspect {

    @Pointcut("@annotation(com.merchant.flow.anotation.TestPoint)")
    public void testcheck(){};

    @Around("testcheck()")
    public void process(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        TestPoint annotation = method.getAnnotation(TestPoint.class);
        String rule = annotation.rule();
        String[] rules = rule.split("\\.");


        Object[] objs = joinPoint.getArgs();
        String[] parameterNames = signature.getParameterNames();

        int index = 0;
        for (String parameterName : parameterNames) {
            if (parameterName.equals(rules[0])) {
                Object obj = objs[index];
                Object parentObj = null;
                Field field = null;
                for (int i = 0; i < rules.length; i++) {
                    parentObj = obj;
                    String ru = rules[i];
                    field = obj.getClass().getDeclaredField(ru);
                    obj = field.get(obj);
                }
                field.set(parentObj,"__test_"+obj);
            }
            index++;
        }


        Object[] args = joinPoint.getArgs();
        Object arg = args[0];
        Field field = arg.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(arg,rule+"helloAnnotation");
        joinPoint.proceed(joinPoint.getArgs());

    }

    public static void main(String[] args) throws NoSuchFieldException {

        StudentDO studentDO = new StudentDO();
        studentDO.setName("123");
        try {
            Field field = studentDO.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(studentDO,"123");
            System.out.println(studentDO.getName());

        } catch (Exception e) {
            System.out.println("888");
            System.out.println(e);
        }
        System.out.println("000");

    }
}
