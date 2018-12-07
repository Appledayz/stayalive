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
	
	// 1. 역경매 전체목록 조회
	public List<Reverseauction> getReverseauctionAll(){
		return reverseauctionMapper.selectReverseauctionAll();
	}
	// 2. 역경매 등록 폼
	public int addReverseauctionOne(Reverseauction reverseauction) {
		return reverseauctionMapper.insertReverseauction(reverseauction);
	}
	// 3. 역경매 목록 검색
	public List<Reverseauction> getReverseauctionSearchList(String sk, String sv) {
		return reverseauctionMapper.selectReverseauctionSearchList(sk, sv);
	}
	// 4. 역경매 상세 보기
	public Reverseauction getReverseauctionOne(int reverseauctionNo) {
		return reverseauctionMapper.selectReverseauctionOne(reverseauctionNo);
	}
	// 5. 역경매 수정 폼
	public Reverseauction modifyReverseauctionForm(int reverseauctionNo) {
		return reverseauctionMapper.selectReverseauctionOne(reverseauctionNo);
	}
	// 6. 역경매 수정 액션
	public int modifyReverseauctionAction(Reverseauction reverseauction) {
		System.out.println("ReverseauctionService.modifyReverseauctionAction()");
		return reverseauctionMapper.updateReverseauction(reverseauction);
	}
	// 7. 역경매 삭제
	// 8. 입찰 목록 조회
	// 9. 입찰 상세 조회
	// 10. 입찰 등록
	// 11. 입찰 수정 폼
	// 12. 입찰 수정 액션
	// 13. 입찰 삭제
	// 14. 낙찰 등록
	// 15. 낙찰 취소
}
