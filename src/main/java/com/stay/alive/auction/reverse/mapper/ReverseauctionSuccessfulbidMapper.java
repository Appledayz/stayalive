package com.stay.alive.auction.reverse.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;
import com.stay.alive.auction.vo.AuctionStateCategory;

@Mapper
public interface ReverseauctionSuccessfulbidMapper {
	// 낙찰 등록
	int insertReverseauctionSuccessfulbid(ReverseauctionSuccessfulbid reverseauctionSuccessrulbid);
	// 낙찰정보 등록을 위해 정보 조회
	ReverseauctionSuccessfulbid selectForSuccessfulbid(int reverseauctionTenderNo);
	// 역경매 내 낙찰 조회
	ReverseauctionSuccessfulbid selectReverseauctionSuccessfulbid(int reverseauctionNo);
	// 낙찰 삭제
	int deleteReverseauctionSuccessfulbid(int reverseauctionSuccessfulbidNo);
	// 역경매 상태갱신
	int updateReverseauctionState(int reverseauctionNo, AuctionStateCategory auctionStateCategory);
	// "낙찰완료" 상태 조회
	AuctionStateCategory selectAuctionStateByName(String string);
	// 역경매 입찰 상태갱신
	void updateReverseauctionTenderState(int reverseauctionTenderNo, AuctionStateCategory auctionStateCategory);
}
