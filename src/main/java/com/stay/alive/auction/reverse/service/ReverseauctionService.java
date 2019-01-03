package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionMapper;
import com.stay.alive.auction.reverse.mapper.ReverseauctionTenderMapper;
import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.common.PageMaker;
import com.stay.alive.common.PageMakerService;

@Service
@Transactional
public class ReverseauctionService {
	@Autowired
	private ReverseauctionMapper reverseauctionMapper;
	@Autowired
	private ReverseauctionTenderMapper reverseauctionTenderMapper;
	
	// 1. 역경매 전체목록 조회
	// 2. 역경매 등록 폼
	public int addReverseauctionOne(Reverseauction reverseauction) {
		System.out.println("ReverseauctionService.addReverseauctionOne()");
		return reverseauctionMapper.insertReverseauction(reverseauction);
	}
	// 3. 역경매 목록 검색
	public List<Reverseauction> getReverseauctionSearchList(PageMaker pageMaker, String sk, String sv, String date1, String date2) {
		System.out.println("ReverseauctionService.getReverseauctionSearchList()");
		pageMaker.setPagePerBlock(10);
		pageMaker.setRowPerPage(10);
		pageMaker.setAllCount(reverseauctionMapper.selectCountReverseauctionSearch(pageMaker, sk, sv, date1, date2));
		PageMakerService.pageMakerService(pageMaker);
		return reverseauctionMapper.selectReverseauctionSearchList(pageMaker, sk, sv, date1, date2);
	}
	// 4. 역경매 상세 보기
	public Reverseauction getReverseauctionOne(int reverseauctionNo) {
		System.out.println("ReverseauctionService.getReverseauctionOne()");
		reverseauctionMapper.plusReverseauctionHits(reverseauctionNo);
		return reverseauctionMapper.selectReverseauctionOne(reverseauctionNo);
	}
	// 5. 역경매 수정 폼
	public Reverseauction modifyReverseauctionForm(int reverseauctionNo, String sessionId) {
		System.out.println("ReverseauctionService.modifyReverseauctionForm()");
		if(reverseauctionMapper.selectReverseauctionOne(reverseauctionNo).getMemberId().equals(sessionId)
				&& !reverseauctionMapper.selectReverseauctionState(reverseauctionNo).equals("낙찰완료")) {
			return reverseauctionMapper.selectReverseauctionOne(reverseauctionNo);
		}
		return null;
	}
	// 6. 역경매 수정 액션
	public int modifyReverseauctionAction(Reverseauction reverseauction, String sessionId) {
		System.out.println("ReverseauctionService.modifyReverseauctionAction()");
		if(reverseauctionMapper.selectReverseauctionOne(reverseauction.getReverseauctionNo()).getMemberId().equals(sessionId)
				&& !reverseauctionMapper.selectReverseauctionState(reverseauction.getReverseauctionNo()).equals("낙찰완료")) {
			return reverseauctionMapper.updateReverseauction(reverseauction);
		}
		return 0;
	}
	// 7. 역경매 삭제
	public int removeReverseauction(int reverseauctionNo, String sessionId) {
		System.out.println("ReverseauctionService.removeReverseauction()");
		int i=0;
		if(!reverseauctionMapper.selectReverseauctionState(reverseauctionNo).equals("낙찰완료")
				&& reverseauctionMapper.selectReverseauctionOne(reverseauctionNo).getMemberId().equals(sessionId)) {
			i+=reverseauctionTenderMapper.deleteReverseauctionTender(reverseauctionNo);
			i+=reverseauctionMapper.deleteReverseauction(reverseauctionNo);
		}
		return i;
	}
	// 역경매목록 조회 (memberId로)
	public List<Reverseauction> getReverseauctionListById(Reverseauction reverseauction) {
		System.out.println("ReverseauctionService.selectReverseauctionListById()");
		return reverseauctionMapper.selectReverseauctionListById(reverseauction);
	}
	// 촤근 역경매 3개 조회
	public List<Reverseauction> getRecentReverseauctionList() {
		System.out.println("ReverseauctionService.getRecentReverseauctionList()");
		return reverseauctionMapper.selectRecentReverseauctionList();
	}
}
