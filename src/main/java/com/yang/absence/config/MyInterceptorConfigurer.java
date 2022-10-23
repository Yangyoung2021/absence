package com.yang.absence.config;

import com.yang.absence.interceptor.GeneralAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	//这种方式会拦截所有请求
    	//registry.addInterceptor(new GeneralAuthInterceptor());
    	//这种方式会拦截指定的请求
        registry.addInterceptor(new GeneralAuthInterceptor()).addPathPatterns("/**");
    }
}