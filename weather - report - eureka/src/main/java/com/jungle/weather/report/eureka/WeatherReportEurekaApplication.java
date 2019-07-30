package com.jungle.weather.report.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherReportEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherReportEurekaApplication.class, args);
    }

}
