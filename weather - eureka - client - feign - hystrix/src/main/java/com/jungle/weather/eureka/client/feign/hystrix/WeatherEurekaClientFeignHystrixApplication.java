package com.jungle.weather.eureka.client.feign.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class WeatherEurekaClientFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherEurekaClientFeignHystrixApplication.class, args);
    }

}
