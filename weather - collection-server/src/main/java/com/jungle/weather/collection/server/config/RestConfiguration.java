package com.jungle.weather.collection.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Configuration.
 *
 *
 * @since 1.0.0 2017年11月22日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Configuration
public class RestConfiguration {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

}
