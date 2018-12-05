package com.stay.alive.auction.reverse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.auction.reverse.vo.Reverseauction;

@Mapper
public interface ReverseauctionMapper {
	List<Reverseauction> selectReverseauctionAll();
	int insertReverseauction(Reverseauction reverseauction);
	List<Reverseauction> selectReverseauctionSearchList(String sk, String sv);
}