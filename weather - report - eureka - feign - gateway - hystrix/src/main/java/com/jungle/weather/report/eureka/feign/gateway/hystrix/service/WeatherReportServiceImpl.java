package com.jungle.weather.report.eureka.feign.gateway.hystrix.service;

import com.jungle.weather.report.eureka.feign.gateway.hystrix.vo.Weather;
import com.jungle.weather.report.eureka.feign.gateway.hystrix.vo.WeatherResponse;
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
		Weather data =null;
		if(resp!=null){
			 data = resp.getData();
		}
		return data;
	}

}
