package com.stay.alive.auction.reverse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

@Mapper
public interface ReverseauctionTenderMapper {
	// 역경매 입찰 등록
	int insertReverseauctionTender(ReverseauctionTender reverseauctionTender);
	// 역경매 내 입찰목록 조회
	List<ReverseauctionTender> selectTenderListForOneReverseauction(int reverseauctionNo);
	// 역경매 입찰 상세조회
	ReverseauctionTender selectReverseauctionTenderOne(int reverseauctionTenderNo);
	// 역경매 입찰 수정
	int updateReverseauctionTender(ReverseauctionTender reverseauctionTender);
	// 역경매 입찰 삭제
	int deleteReverseauctionTenderOne(int reverseauctionTenderNo);
	// 역경매 내 입찰목록 전체삭제
	int deleteReverseauctionTender(int reverseauctionNo);
	// 입찰수 1 더하기
	void updateReverseauctionTenderCount(int reverseauctionNo);
}
