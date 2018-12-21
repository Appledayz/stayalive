package com.stay.alive.auction.dutch.controller;

import static org.quartz.DateBuilder.dateOf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.auction.dutch.service.DutchAuctionRegisterJob;
import com.stay.alive.auction.dutch.vo.DutchAuction;

@Controller
@RequestMapping("dutchauction")
public class DutchauctionController {
	private int groupNum = 0;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	public JobDetail sampleJobDetail() {
		DutchAuction dutchauction = new DutchAuction();
		dutchauction.setAccommodationNo(groupNum);
		JobDataMap jabDataMap = new JobDataMap();
		jabDataMap.put("dutchauction", dutchauction);
		return JobBuilder.newJob(DutchAuctionRegisterJob.class).withIdentity("DutchAuctionRegisterJob" ,"group"+ groupNum )
				.usingJobData(jabDataMap).storeDurably().build();
	}
	public Trigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever();
		return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
				.withIdentity("DutchAuctionRegisterTrigger","group"+groupNum).endAt(dateOf(12, 1, 0, 21, 12 , 2018)).withSchedule(scheduleBuilder).build();
	}
	@GetMapping("register")
	public String dutchauctionRegister() throws SchedulerException, ParseException {
/*		Scheduler sched = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail = sampleJobDetail();
		Trigger trigger = sampleJobTrigger();
		sched.scheduleJob(jobDetail, trigger);
		groupNum++;
		sched.start();
		Calendar cal = Calendar.getInstance();
		String dateStr = "2018-10-17 09:03:56";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		cal.setTime(dt.parse(dateStr));
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		*/
		return "dutchauction/dutchauctionRegister";
	}
	@PostMapping("register")
	public String dutchauctionRegisterAction() {
/*		Scheduler sched = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail = sampleJobDetail();
		Trigger trigger = sampleJobTrigger();
		sched.scheduleJob(jobDetail, trigger);
		groupNum++;
		sched.start();*/
		
		return "dutchauction/dutchauctionRegister";
	}	
	
	
}
