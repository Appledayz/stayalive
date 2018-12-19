package com.stay.alive.auction.reverse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;
import com.stay.alive.common.PageMaker;

@Mapper
public interface ReverseauctionMapper {
	// 역경매목록 전체조회
	List<Reverseauction> selectReverseauctionList(PageMaker pageMaker);
	// 역경매목록 검색조회
	List<Reverseauction> selectReverseauctionSearchList(PageMaker pageMaker, String sk, String sv, String date1, String date2);
	// 역경매 등록
	int insertReverseauction(Reverseauction reverseauction);
	// 역경매 상세조회
	Reverseauction selectReverseauctionOne(int reverseauctionNo);
	// 역경매 수정
	int updateReverseauction(Reverseauction reverseauction);
	// 역경매 삭제
	int deleteReverseauction(int reverseauctionNo);
	// 낙찰 등록
	int insertReverseauctionSuccessfulbid(ReverseauctionSuccessfulbid reverseauctionSuccessrulbid);
	// 낙찰정보 등록을 위해 정보 조회
	ReverseauctionSuccessfulbid selectForSuccessfulbid(int reverseauctionTenderNo);
	// 역경매 내 낙찰 조회
	ReverseauctionSuccessfulbid selectReverseauctionSuccessfulbid(int reverseauctionNo);
	// 역경매 갯수 조회
	int selectCountReverseauction();
	// 역경매 검색 갯수 조회
	int selectCountReverseauctionSearch(PageMaker pageMaker, String sk, String sv, String date1, String date2);
	// 낙찰 삭제
	int deleteReverseauctionSuccessfulbid(int reverseauctionSuccessfulbidNo);
	// 입찰수 1 더하기
	void updateReverseauctionTenderCount(int reverseauctionNo);
}