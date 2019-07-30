package com.jungle.weather.report.eureka.feign.service;

import com.jungle.weather.report.eureka.feign.vo.Forecast;
import com.jungle.weather.report.eureka.feign.vo.Weather;
import com.jungle.weather.report.eureka.feign.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Weather Report Service.
 * 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataClient weatherDataClient;
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
		Weather data = resp.getData();
		return data;
	}

}
