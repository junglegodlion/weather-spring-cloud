package com.jungle.weather.report.eureka.feign.service;

import com.jungle.weather.report.eureka.feign.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Weather Data Client.
 * 
 */
@FeignClient("weather-data-eureka")
public interface WeatherDataClient {
	
	@GetMapping("/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
