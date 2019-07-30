package com.jungle.weather.report.eureka.controller;
import java.util.ArrayList;
import java.util.List;

import com.jungle.weather.report.eureka.service.WeatherReportService;
import com.jungle.weather.report.eureka.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Weather Report Controller.
 *
 * @since 1.0.0 2017年11月24日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

	@Autowired
	private WeatherReportService weatherReportService;

	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 获取城市ID列表
		// TODO 改为由城市数据API微服务来提供数据
		List<City> cityList = null;

		try {

			// TODO 改为由城市数据API微服务提供数据
			//下面是造的假数据
			cityList = new ArrayList<>();
			City city = new City();
			city.setCityId("101280601");
			city.setCityName("深圳");
			cityList.add(city);

		} catch (Exception e) {
			logger.error("Exception!", e);
		}

		model.addAttribute("title", "老卫的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
