package com.jungle.weather.eureka.client.feign.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * City Client.
 * 
 */
@FeignClient("weather-city-eureka")
public interface CityClient {

	@GetMapping("/cities")
	String listCity();


}
