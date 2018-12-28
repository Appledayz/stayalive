package com.stay.alive.auction.dutch.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.dutch.vo.DutchAuction;

@Mapper 
public interface DutchauctionMapper {
	public void insertDutchAuction(DutchAuction dutchAuction);
	public void updateCurrentPrice(DutchAuction dutchAuction);
	public void updateStateCategoryToExpired(DutchAuction dutchAuction);
	public ArrayList<DutchAuction> selectDutchAuctionAll();
}
