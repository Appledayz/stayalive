package com.stay.alive.auction.dutch.service;

import java.util.ArrayList;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.stay.alive.auction.dutch.mapper.DutchauctionBidMapper;
import com.stay.alive.auction.dutch.vo.DutchAuctionBid;
import com.sun.javafx.collections.MappingChange.Map;

@Service
public class DutchauctionBidService {
	@Autowired
	DutchauctionBidMapper dutchauctionBidMapper;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	public ArrayList<Map<String, Object>> getDutchauctionSuccessfulbidFromId(String memberId, String groupName) {
		return dutchauctionBidMapper.selectDutchauctionSuccessfulbidFromId(memberId, groupName);
	}
	public void addDutchauctionSuccessfulbid(DutchAuctionBid dutchAuctionBid) {
		dutchauctionBidMapper.insertDutchauctionSuccessfulbid(dutchAuctionBid);
	}
	public void removeJobInCurrentScheduler(int dutchActionNo) {
		JobKey registerJobKey = JobKey.jobKey("registerJob"+dutchActionNo);
		JobKey closeJobKey = JobKey.jobKey("closeJob"+dutchActionNo);
		if(registerJobKey != null && closeJobKey != null) {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			try {
				scheduler.deleteJob(registerJobKey);
				scheduler.deleteJob(closeJobKey);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
