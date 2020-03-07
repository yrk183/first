package com.merchant.flow;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestBean {

    @Bean
    public FilterRegistrationBean getFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setName("myfilter");
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/test"));
        return filterRegistrationBean;
    }
}
