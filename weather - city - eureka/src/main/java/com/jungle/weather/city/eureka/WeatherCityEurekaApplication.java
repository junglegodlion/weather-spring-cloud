package com.jungle.weather.city.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCityEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCityEurekaApplication.class, args);
    }

}
