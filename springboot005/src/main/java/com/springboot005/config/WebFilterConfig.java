package com.springboot005.config;

import com.springboot005.core.WebFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
@Component
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(webfilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("webfilter");
        //registration.setFilter(new SessionFilter());
        return registration;
    }
    @Bean(name = "webfilter")
    private Filter webfilter() {
        return  new WebFilter();
    }
}
