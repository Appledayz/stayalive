package com.stay.alive.auction.reverse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.reverse.vo.Reverseauction;
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
	// 역경매 갯수 조회
	int selectCountReverseauction();
	// 역경매 검색 갯수 조회
	int selectCountReverseauctionSearch(PageMaker pageMaker, String sk, String sv, String date1, String date2);
	// 역경매 상세조회 조회수 업데이트
	int plusReverseauctionHits(int reverseauctionNo);
	// 역경매 상태 조회
	String selectReverseauctionState(int reverseauctionNo);
}