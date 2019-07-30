package com.jungle.weather.config;

		import com.jungle.weather.job.WeatherDataSyncJob;
		import org.quartz.JobBuilder;
		import org.quartz.JobDetail;
		import org.quartz.SimpleScheduleBuilder;
		import org.quartz.Trigger;
		import org.quartz.TriggerBuilder;
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;


/**
 * Quartz Configuration.
 *
 * @since 1.0.0 2017年11月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Configuration
public class QuartzConfiguration {

	private static final int TIME = 1800; // 更新频率

	// JobDetail
	@Bean
	public JobDetail weatherDataSyncJobDetail() {
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
				.storeDurably().build();
	}

	// Trigger
	@Bean
	public Trigger weatherDataSyncTrigger() {

		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(TIME).repeatForever();

		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
				.withIdentity("weatherDataSyncTrigger").withSchedule(schedBuilder).build();
	}
}
