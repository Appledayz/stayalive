package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionTenderMapper;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

@Service
@Transactional
public class ReverseauctionTenderService {
	@Autowired
	private ReverseauctionTenderMapper reverseauctionTenderMapper;
	
	// 8. 입찰 목록 조회 (역경매 내 조회)
	public List<ReverseauctionTender> getTenderListForOneReverseauction(int reverseauctionNo){
		System.out.println("ReverseauctionService.getTenderListForOneReverseauction()");
		return reverseauctionTenderMapper.selectTenderListForOneReverseauction(reverseauctionNo);
	}
	// 9. 입찰 상세 조회
	public ReverseauctionTender getTenderDetail(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionService.getTenderDetail()");
		return reverseauctionTenderMapper.selectReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 10. 입찰 등록
	public int addReverseauctionTender(ReverseauctionTender reverseauctionTender) {
		System.out.println("ReverseauctionService.addReverseauctionTender()");
		System.out.println("reverseauctionNo : "+reverseauctionTender.getReverseauctionNo());
		return reverseauctionTenderMapper.insertReverseauctionTender(reverseauctionTender);
	}
	// 11. 입찰 수정 폼
	public ReverseauctionTender modifyReverseauctionTenderForm(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionService.modifyReverseauctionTender()");
		return reverseauctionTenderMapper.selectReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 12. 입찰 수정 액션
	public int modifyReverseauctionTenderAction(ReverseauctionTender reverseauctionTender) {
		System.out.println("ReverseauctionService.modifyReverseauctionTenderAction()");
		System.out.println("reverseauctionNo : "+reverseauctionTender.getReverseauctionNo());
		
		return reverseauctionTenderMapper.updateReverseauctionTender(reverseauctionTender);
	}
	// 13. 입찰 삭제
	public int removeReverseauctionTender(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionService.removeReverseauctionTender()");
		return reverseauctionTenderMapper.deleteReverseauctionTenderOne(reverseauctionTenderNo);
	}
}
