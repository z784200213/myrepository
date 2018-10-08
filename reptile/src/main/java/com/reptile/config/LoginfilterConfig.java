package com.reptile.config;

import com.reptile.filter.Loginfilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class LoginfilterConfig {
    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(loginfilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("loginfilter");
        //registration.setFilter(new SessionFilter());
        return registration;
    }

    /**
     * 创建一个bean
     * @return
     */
    @Bean(name = "loginfilter")
    public Filter loginfilter() {
        return new Loginfilter();
    }
}
