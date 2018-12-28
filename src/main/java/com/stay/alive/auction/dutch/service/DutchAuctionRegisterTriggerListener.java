package com.stay.alive.auction.dutch.service;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.listeners.TriggerListenerSupport;

import com.stay.alive.auction.dutch.vo.DutchAuction;

public class DutchAuctionRegisterTriggerListener extends TriggerListenerSupport{
	
	private String name;
	DutchAuctionRegisterTriggerListener(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
    	
		System.out.println(trigger.getEndTime());
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		DutchAuction dutchAuction = (DutchAuction)jobDataMap.get("dutchAuction");
    }
	
	public void triggerComplete(Trigger trigger, JobExecutionContext context, CompletedExecutionInstruction triggerInstructionCode) {
		
    }


            
}

