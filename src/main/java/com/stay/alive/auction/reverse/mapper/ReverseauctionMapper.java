package com.stay.alive.auction.reverse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

@Mapper
public interface ReverseauctionMapper {
	List<Reverseauction> selectReverseauctionAll();
	int insertReverseauction(Reverseauction reverseauction);
	List<Reverseauction> selectReverseauctionSearchList(String sk, String sv);
	Reverseauction selectReverseauctionOne(int reverseauctionNo);
	int updateReverseauction(Reverseauction reverseauction);
	int deleteReverseauction(int reverseauctionNo);
	int insertReverseauctionTender(ReverseauctionTender reverseauctionTender);
	List<ReverseauctionTender> selectTenderListForOneReverseauction();
	ReverseauctionTender selectReverseauctionTenderOne(int reverseauctionTenderNo);
}