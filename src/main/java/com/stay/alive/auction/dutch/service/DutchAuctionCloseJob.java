package com.stay.alive.auction.dutch.service;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.stay.alive.auction.dutch.mapper.DutchauctionMapper;
import com.stay.alive.auction.dutch.vo.DutchAuction;

public class DutchAuctionCloseJob extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		DutchAuction dutchAuction = (DutchAuction)jobDataMap.get("dutchAuction");
		DutchauctionMapper dutchauctionMapper = (DutchauctionMapper)jobDataMap.get("dutchauctionMapper");
		JobKey registerJobKey = JobKey.jobKey("registerJob"+dutchAuction.getDutchauctionNo());
		JobKey closeJobKey = JobKey.jobKey("closeJob"+dutchAuction.getDutchauctionNo());
		try {
			context.getScheduler().deleteJob(registerJobKey);
			context.getScheduler().deleteJob(closeJobKey);
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dutchAuction.setAuctionStateCategoryNo(4);
		dutchAuction.setAuctionStateCategoryName("만료");
		dutchauctionMapper.updateStateCategory(dutchAuction); //데이터베이스에서 카테고리 업데이트
		
	}

}
