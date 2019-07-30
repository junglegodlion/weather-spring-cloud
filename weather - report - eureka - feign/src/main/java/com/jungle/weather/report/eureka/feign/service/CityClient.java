package com.jungle.weather.report.eureka.feign.service;


import com.jungle.weather.report.eureka.feign.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 * City Client.
 * 
 */
@FeignClient("weather-city-eureka")
public interface CityClient {
	
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
