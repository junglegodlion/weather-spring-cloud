package com.jungle.weather.report.eureka.feign.gateway.service;


import com.jungle.weather.report.eureka.feign.gateway.vo.City;
import com.jungle.weather.report.eureka.feign.gateway.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Data Client.
 * 
 */
@FeignClient("msa-weather-eureka-client-zuul")
public interface DataClient {

	/**
	 * 获取城市列表
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;

	/**
	 * 根据城市ID查询天气数据
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
