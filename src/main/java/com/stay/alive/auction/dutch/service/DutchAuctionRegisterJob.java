package com.stay.alive.auction.dutch.service;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import com.stay.alive.auction.dutch.mapper.DutchauctionMapper;
import com.stay.alive.auction.dutch.vo.DutchAuction;

public class DutchAuctionRegisterJob extends QuartzJobBean {
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		//System.out.println(context.getJobDetail().getKey().getName());;
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		DutchAuction dutchAuction = (DutchAuction)jobDataMap.get("dutchAuction");
		DutchauctionMapper dutchauctionMapper = (DutchauctionMapper)jobDataMap.get("dutchauctionMapper");
		int updatePrice = dutchAuction.getDutchauctionUpdatePrice(); //데이터베이스에서는 0값이 들어있지만 dutchAuction객체에는 시작가격(dutchauctionStartprice)이 들어있다
		if(updatePrice > dutchAuction.getMaximumDiscountPrice()) {
			updatePrice = dutchAuction.getDutchauctionUpdatePrice() - dutchAuction.getDutchauctionSaleUnit();
			dutchAuction.setDutchauctionUpdatePrice(updatePrice);
			dutchauctionMapper.updateCurrentPrice(dutchAuction); //갱신된 가격 데이터베이스에 업데이트
			System.out.println(String.format("현재가격은 %s 원 입니다.", dutchAuction.getDutchauctionUpdatePrice()));
		}
		else {
			JobKey registerJobKey = JobKey.jobKey("registerJob"+dutchAuction.getDutchauctionNo());
			JobKey closeJobKey = JobKey.jobKey("closeJob"+dutchAuction.getDutchauctionNo());
			try {

				context.getScheduler().deleteJob(registerJobKey);
				context.getScheduler().deleteJob(closeJobKey);
				dutchAuction.setAuctionStateCategoryNo(4);
				dutchAuction.setAuctionStateCategoryName("만료");
				dutchauctionMapper.updateStateCategoryToExpired(dutchAuction); //데이터베이스에서 카테고리 업데이트
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}