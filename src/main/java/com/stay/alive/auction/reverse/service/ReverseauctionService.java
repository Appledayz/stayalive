package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionMapper;
import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

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
	public int removeReverseauction(int reverseauctionNo) {
		System.out.println("ReverseauctionService.removeReverseauction()");
		reverseauctionMapper.deleteReverseauction(reverseauctionNo);
		return 0;
	}
	// 8. 입찰 목록 조회 (역경매 내 조회)
	public List<ReverseauctionTender> getTenderListForOneReverseauction(int reverseauctionNo){
		System.out.println("ReverseauctionService.getTenderListForOneReverseauction()");
		return reverseauctionMapper.selectTenderListForOneReverseauction();
	}
	// 9. 입찰 상세 조회
	public ReverseauctionTender getTenderDetail(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionService.getTenderDetail()");
		return reverseauctionMapper.selectReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 10. 입찰 등록
	public int addReverseauctionTender(ReverseauctionTender reverseauctionTender) {
		System.out.println("ReverseauctionService.addReverseauctionTender()");
		return reverseauctionMapper.insertReverseauctionTender(reverseauctionTender);
	}
	// 11. 입찰 수정 폼
	public ReverseauctionTender modifyReverseauctionTenderForm() {
		System.out.println("ReverseauctionService.modifyReverseauctionTender()");
		return null;
	}
	// 12. 입찰 수정 액션
	public int modifyReverseauctionTenderAction() {
		System.out.println("ReverseauctionService.modifyReverseauctionTenderAction()");
		return 0;
	}
	// 13. 입찰 삭제
	public int removeReverseauctionTender() {
		System.out.println("ReverseauctionService.removeReverseauctionTender()");
		return 0;
	}
	// 14. 낙찰 등록
	public int addReverseauctionSuccessfulbid() {
		System.out.println("ReverseauctionService.addReverseauctionSuccessfulbid()");
		return 0;
	}
	// 15. 낙찰 취소
	public int cancelReverseauctionSuccessfulbid() {
		System.out.println("ReverseauctionService.cancelReverseauctionSuccessfulbid()");
		return 0;
	}
}
