package com.stay.alive.auction.dutch.service;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.stay.alive.auction.dutch.vo.DutchAuction;

public class DutchAuctionRegisterJob extends QuartzJobBean {
	@Autowired
	private DutchauctionService dutchauctionService;
	private int num;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//System.out.println(context.getJobDetail().getKey().getName());;
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		DutchAuction dutchAuction = (DutchAuction)jobDataMap.get("dutchauction");
		num = dutchAuction.getAccommodationNo();
		num += 1;
		dutchAuction.setAccommodationNo(num);
		System.out.println(String.format("Hello %s!", dutchAuction.getAccommodationNo()));
	}

}