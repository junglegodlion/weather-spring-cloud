package com.jungle.weather.report.eureka.service;

import com.jungle.weather.report.eureka.vo.Forecast;
import com.jungle.weather.report.eureka.vo.Weather;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Weather Report Service.
 * 
 * @since 1.0.0 2017年11月24日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Override
	public Weather getDataByCityId(String cityId) {
		// TODO 改为由天气数据API微服务来提供
		//暂时先造点假数据来运行该应用
		Weather data = new Weather();
		data.setAqi("81");
		data.setCity("深圳");
		data.setGanmao("容易感冒！多穿衣");
		data.setWendu("22");

		List<Forecast> forecastList = new ArrayList<>();

		Forecast forecast = new Forecast();
		forecast.setDate("25日星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setLow("低温 1度");
		forecastList.add(forecast);

		forecast = new Forecast();
		forecast.setDate("26日星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setLow("低温 1度");
		forecastList.add(forecast);

		forecast = new Forecast();
		forecast.setDate("27日星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setLow("低温 1度");
		forecastList.add(forecast);

		forecast = new Forecast();
		forecast.setDate("28日星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setLow("低温 1度");
		forecastList.add(forecast);

		forecast = new Forecast();
		forecast.setDate("29日星期天");
		forecast.setType("晴");
		forecast.setFengxiang("无风");
		forecast.setHigh("高温 11度");
		forecast.setLow("低温 1度");
		forecastList.add(forecast);

		data.setForecast(forecastList);
		return data;
	}

}
