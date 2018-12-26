package com.stay.alive.auction.dutch.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.dutch.vo.DutchAuction;

@Mapper 
public interface DutchauctionMapper {
	public void insertDutchAuction(DutchAuction dutchAuction);
	
}
