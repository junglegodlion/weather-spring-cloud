package com.jungle.weather.collection.server.job;

		import com.jungle.weather.collection.server.service.WeatherDataCollectionService;
		import com.jungle.weather.collection.server.vo.City;
		import org.quartz.JobExecutionContext;
		import org.quartz.JobExecutionException;
		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.scheduling.quartz.QuartzJobBean;

		import java.util.ArrayList;
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
	private WeatherDataCollectionService weatherDataCollectionService;
	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Weather Data Sync Job. Start！");
		// 获取城市ID列表
		//TODO 改为由城市API微服务来提供数据
		List<City> cityList = null;

		try {
			// TODO 改为由城市数据API微服务来提供数据
			//暂时先写死，后续会修改代码的
			cityList = new ArrayList<>();
			City city = new City();
			city.setCityId("101280601");
			cityList.add(city);
		} catch (Exception e) {
			logger.error("Exception!", e);
		}

		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			logger.info("Weather Data Sync Job, cityId:" + cityId);

			weatherDataCollectionService.syncDateByCityId(cityId);
		}

		logger.info("Weather Data Sync Job. End！");
	}

}
