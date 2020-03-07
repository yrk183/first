//package com.merchant.flow;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.SmartLifecycle;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class test implements SmartLifecycle,ApplicationContextAware {
//
//
//
//Map<String,String> map = new HashMap<>();
//
//
//    @Override
//    public void start() {
//        map.put("123","123");
//    }
//
//    @Override
//    public void stop() {
//
//    }
//
//    @Override
//    public boolean isRunning() {
//        return false;
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        Object bean = applicationContext.getBean("");
//    }
//}
