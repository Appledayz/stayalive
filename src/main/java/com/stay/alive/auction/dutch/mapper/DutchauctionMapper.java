package com.stay.alive.auction.dutch.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.dutch.vo.DutchAuction;
import com.stay.alive.common.PageMaker;

@Mapper 
public interface DutchauctionMapper {
	public void insertDutchAuction(DutchAuction dutchAuction);
	public void updateCurrentPrice(DutchAuction dutchAuction);
	public void updateStateCategoryToExpired(DutchAuction dutchAuction);
	public ArrayList<Map<String, Object>> selectDutchAuctionList(PageMaker pageMaker);
	public ArrayList<Map<String, Object>> selectClosedDutchAuctionList();
	public int selectCountDutchAuction();
	public int selectCountClosedDutchAuction();
	public Map<String,Object> selectDutchAuctionDetail(int dutchauctionNo);
}
