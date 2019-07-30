package com.jungle.weather.report.eureka.feign.gateway.service;

import com.jungle.weather.report.eureka.feign.gateway.vo.Weather;
import com.jungle.weather.report.eureka.feign.gateway.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Weather Report Service.
 * 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private DataClient dataClient;
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = dataClient.getDataByCityId(cityId);
		Weather data = resp.getData();
		return data;
	}

}
