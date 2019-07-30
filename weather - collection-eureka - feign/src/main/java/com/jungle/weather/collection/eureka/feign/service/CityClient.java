package com.jungle.weather.collection.eureka.feign.service;

import java.util.List;

import com.jungle.weather.collection.eureka.feign.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * City Client.
 * 
 */
@FeignClient("weather-city-eureka")
public interface CityClient {
	
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
