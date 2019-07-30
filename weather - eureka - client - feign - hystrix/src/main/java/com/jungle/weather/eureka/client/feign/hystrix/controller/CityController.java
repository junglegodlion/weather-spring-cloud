package com.jungle.weather.eureka.client.feign.hystrix.controller;

		import com.jungle.weather.eureka.client.feign.hystrix.service.CityClient;
		import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.web.bind.annotation.GetMapping;
		import org.springframework.web.bind.annotation.RestController;

/**
 * City Controller.
 *
 */
@RestController
public class CityController {

	@Autowired
	private CityClient cityClient;

	@GetMapping("/cities")
	@HystrixCommand(fallbackMethod = "defaultCities")
	public String listCity() {
		// 通过Feign客户端来查找
		String body = cityClient.listCity();
		return body;
	}

	public String defaultCities(){
		return "City Data Server is down";
	}
}
