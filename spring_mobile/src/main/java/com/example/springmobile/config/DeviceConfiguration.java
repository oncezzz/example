package com.example.springmobile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/***
 *
 * @author once
 * @date 2020/9/26 0:48
 *
 */
@Configuration
public class DeviceConfiguration extends WebMvcConfigurationSupport {

//    @Bean
//    public DeviceResolverHandlerInterceptor
//    deviceResolverHandlerInterceptor() {
//        return new DeviceResolverHandlerInterceptor();
//    }
//
//    @Bean
//    public SitePreferenceHandlerInterceptor
//    sitePreferenceHandlerInterceptor() {
//        return new SitePreferenceHandlerInterceptor();
//    }
//
//    @Bean
//    public SitePreferenceHandlerMethodArgumentResolver
//    sitePreferenceHandlerMethodArgumentResolver() {
//        return new SitePreferenceHandlerMethodArgumentResolver();
//    }

    @Bean
    public DeviceResolverHandlerInterceptor
    deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver
    deviceHandlerMethodArgumentResolver() {
        return new DeviceHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
    }
}
