package com.jungle.weather.eureka.client.feign.controller;

		import com.jungle.weather.eureka.client.feign.service.CityClient;
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
	public String listCity() {
		// 通过Feign客户端来查找
		String body = cityClient.listCity();
		return body;
	}
}
