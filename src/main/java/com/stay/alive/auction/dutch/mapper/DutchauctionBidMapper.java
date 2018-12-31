package com.stay.alive.auction.dutch.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.dutch.vo.DutchAuctionBid;

@Mapper
public interface DutchauctionBidMapper {
	ArrayList<DutchAuctionBid> selectDutchauctionSuccessfulbidFromId(String memberId);
}
