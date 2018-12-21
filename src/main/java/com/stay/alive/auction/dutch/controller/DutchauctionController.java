package com.stay.alive.auction.dutch.controller;

import static org.quartz.DateBuilder.dateOf;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dutchauction")
public class DutchauctionController {
	private int groupNum = 0;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	public JobDetail sampleJobDetail() {
		return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob" ,"group"+ groupNum )
				.usingJobData("name", "World").storeDurably().build();
	}
	public Trigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever();

		return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
				.withIdentity("trigger","group"+groupNum).endAt(dateOf(11, 10, 0, 21, 12 , 2018)).withSchedule(scheduleBuilder).build();
	}
	@GetMapping("register")
	public String dutchauctionRegister() throws SchedulerException {
		Scheduler sched = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail = sampleJobDetail();
		Trigger trigger = sampleJobTrigger();
		sched.scheduleJob(jobDetail, trigger);
		groupNum++;
		sched.start();

		return "dutchauction/dutchauctionRegister";
	}
}
