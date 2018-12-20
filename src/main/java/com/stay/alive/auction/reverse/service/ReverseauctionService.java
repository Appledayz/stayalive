package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionMapper;
import com.stay.alive.auction.reverse.mapper.ReverseauctionTenderMapper;
import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;
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
	public List<Reverseauction> getReverseauctionList(PageMaker pageMaker){
		System.out.println("ReverseauctionService.getReverseauctionList()");
		pageMaker.setPagePerBlock(10);
		pageMaker.setRowPerPage(10);
		pageMaker.setAllCount(reverseauctionMapper.selectCountReverseauction());
		PageMakerService.pageMakerService(pageMaker);
		return reverseauctionMapper.selectReverseauctionList(pageMaker);
	}
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
		return reverseauctionMapper.selectReverseauctionOne(reverseauctionNo);
	}
	// 5. 역경매 수정 폼
	public Reverseauction modifyReverseauctionForm(int reverseauctionNo) {
		System.out.println("ReverseauctionService.modifyReverseauctionForm()");
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
		int i=0;
		i+=reverseauctionTenderMapper.deleteReverseauctionTender(reverseauctionNo);
		i+=reverseauctionMapper.deleteReverseauction(reverseauctionNo);
		return i;
	}
}
