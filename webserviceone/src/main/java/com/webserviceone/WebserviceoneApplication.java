package com.webserviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WebserviceoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceoneApplication.class, args);
    }
}
