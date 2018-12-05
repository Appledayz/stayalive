package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionMapper;
import com.stay.alive.auction.reverse.vo.Reverseauction;

@Service
@Transactional
public class ReverseauctionService {
	@Autowired
	private ReverseauctionMapper reverseauctionMapper;
	
	// 역경매 전체목록 조회
	public List<Reverseauction> getReverseauctionAll(){
		return reverseauctionMapper.selectReverseauctionAll();
	}
	// 역경매 입력
	public int addReverseauctionOne(Reverseauction reverseauction) {
		return reverseauctionMapper.insertReverseauction(reverseauction);
	}
	// 역경매 목록 검색
	public List<Reverseauction> getReverseauctionSearchList(String sk, String sv) {
		return reverseauctionMapper.selectReverseauctionSearchList(sk, sv);
	}
}
