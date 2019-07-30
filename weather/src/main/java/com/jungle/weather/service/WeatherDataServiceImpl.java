package com.jungle.weather.service;

import java.io.IOException;

import com.jungle.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * WeatherDataService 实现.
 * 
 * @since 1.0.0 2017年11月22日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		String uri = WEATHER_URI + "citykey=" + cityId;
		return this.doGetWeahter(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		String uri = WEATHER_URI + "city=" + cityName;
		return this.doGetWeahter(uri);
	}
	
	private WeatherResponse doGetWeahter(String uri) {
		System.out.println("uri is " + uri);

 		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

		System.out.println("respString is " + respString);
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse resp = null;
		String strBody = null;



		System.out.println("code is " + respString.getStatusCodeValue());


		if (respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
		}

		try {

			resp = mapper.readValue(strBody, WeatherResponse.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resp;
	}

}
