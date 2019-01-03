package com.stay.alive.auction.dutch.mapper;

import java.util.ArrayList;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.stay.alive.auction.dutch.vo.DutchAuctionBid;


@Mapper
public interface DutchauctionBidMapper {
	ArrayList<Map<String, Object>> selectDutchauctionSuccessfulbidFromId(String memberId, String groupName);
	public void insertDutchauctionSuccessfulbid(DutchAuctionBid dutchAuctionBid);
}
