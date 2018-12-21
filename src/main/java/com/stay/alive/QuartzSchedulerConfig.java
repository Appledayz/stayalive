package com.stay.alive;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzSchedulerConfig {
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {        
	    SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
	    Properties quartzProperties = new Properties();
	    quartzProperties.put("org.quartz.scheduler.instanceName", "SchedulerInit");
	    quartzProperties.put("org.quartz.scheduler.instanceId", "AUTO");
		quartzProperties.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
	    quartzProperties.put("org.quartz.threadPool.threadCount", "20");
		quartzProperties.put("org.quartz.threadPool.threadPriority", "5");
		quartzProperties.put("org.quartz.jobStore.misfireThreshold", "60000");
		quartzProperties.put("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
	    scheduler.setQuartzProperties(quartzProperties);
	    return scheduler;
	}
}
