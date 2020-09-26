package com.example.springmobile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.*;
import org.springframework.mobile.device.site.SitePreferenceHandlerInterceptor;
import org.springframework.mobile.device.site.SitePreferenceHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/***
 *
 * @author once
 * @date 2020/9/26 0:48
 *
 */
@Configuration
public class MobileConfiguration implements WebMvcConfigurer {

    @Bean
    public DeviceResolver deviceResolver() {
//        List<String> normalUserAgent = List.of("iphone");
        List<String> normalUserAgent = List.of("Android");
        return new LiteDeviceResolver(normalUserAgent);
    }

    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor(deviceResolver());
    }

    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
        return new DeviceHandlerMethodArgumentResolver();
    }

    @Bean
    public DeviceWebArgumentResolver deviceWebArgumentResolver() {
        return new DeviceWebArgumentResolver();
    }

    @Bean
    public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
        return new SitePreferenceHandlerInterceptor();
    }

    @Bean
    public SitePreferenceHandlerMethodArgumentResolver sitePreferenceWebArgumentResolver() {
        return new SitePreferenceHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
        registry.addInterceptor(sitePreferenceHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(deviceHandlerMethodArgumentResolver());
//        argumentResolvers.add(new ServletWebArgumentResolverAdapter(deviceWebArgumentResolver()));
        argumentResolvers.add(sitePreferenceWebArgumentResolver());
    }
}
