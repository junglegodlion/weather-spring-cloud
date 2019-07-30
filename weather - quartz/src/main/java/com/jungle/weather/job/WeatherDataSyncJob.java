package com.jungle.weather.job;

		import com.jungle.weather.service.CityDataService;
		import com.jungle.weather.service.WeatherDataService;
		import com.jungle.weather.vo.City;
		import org.quartz.JobExecutionContext;
		import org.quartz.JobExecutionException;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.scheduling.quartz.QuartzJobBean;

		import java.util.List;


/**
 * Weather Data Sync Job.
 *
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class WeatherDataSyncJob extends QuartzJobBean {

	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

	@Autowired
	private CityDataService cityDataService;

	@Autowired
	private WeatherDataService weatherDataService;
	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Weather Data Sync Job. Start！");
		// 获取城市ID列表
		List<City> cityList = null;

		try {
			cityList = cityDataService.listCity();
		} catch (Exception e) {
			logger.error("Exception!", e);
		}

		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			logger.info("Weather Data Sync Job, cityId:" + cityId);

			weatherDataService.syncDateByCityId(cityId);
		}

		logger.info("Weather Data Sync Job. End！");
	}

}
