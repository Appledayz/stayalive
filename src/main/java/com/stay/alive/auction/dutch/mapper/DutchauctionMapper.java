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
	public void updateStateCategory(DutchAuction dutchAuction);
	public ArrayList<Map<String, Object>> selectDutchAuctionList(PageMaker pageMaker);
	public ArrayList<Map<String, Object>> selectRecentDutchAuctionList();
	public ArrayList<Map<String, Object>> selectClosedDutchAuctionList();
	public int selectDutchAuctionCount();
	public int selectDutchAuctionSearchCount(String searchKey,String searchWord,String checkInDate,String checkOutDate);
	public int selectClosedDutchAuctionCount();
	public Map<String,Object> selectDutchAuctionDetail(int dutchauctionNo);
	public DutchAuction selectDutchAuctionFromNo(int dutchauctionNo);
	public ArrayList<DutchAuction> selectDutchAuctionsFromId(String mamberId);
	public ArrayList<Map<String, Object>> selectDutchAuctionSearchList(PageMaker pageMaker,String searchKey, String searchWord, String checkInDate, String checkOutDate);
}
