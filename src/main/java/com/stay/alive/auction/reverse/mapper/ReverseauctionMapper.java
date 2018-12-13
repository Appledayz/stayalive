package com.stay.alive.auction.reverse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

@Mapper
public interface ReverseauctionMapper {
	// 역경매목록 전체조회
	List<Reverseauction> selectReverseauctionAll();
	// 역경매목록 검색조회
	List<Reverseauction> selectReverseauctionSearchList(String sk, String sv);
	// 역경매 등록
	int insertReverseauction(Reverseauction reverseauction);
	// 역경매 상세조회
	Reverseauction selectReverseauctionOne(int reverseauctionNo);
	// 역경매 수정
	int updateReverseauction(Reverseauction reverseauction);
	// 역경매 삭제
	int deleteReverseauction(int reverseauctionNo);
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
	// 낙찰 등록
	int insertReverseauctionSuccessfulbid(ReverseauctionSuccessfulbid reverseauctionSuccessrulbid);
	// 낙찰정보 등록을 위해 정보 조회
	ReverseauctionSuccessfulbid selectForSuccessfulbid(int reverseauctionTenderNo);
	// 역경매 내 낙찰 조회
	ReverseauctionSuccessfulbid selectReverseauctionSuccessfulbid(int reverseauctionNo);
}