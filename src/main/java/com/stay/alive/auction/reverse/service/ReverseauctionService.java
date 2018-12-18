package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionMapper;
import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;
import com.stay.alive.common.PageMaker;
import com.stay.alive.common.PageMakerService;

@Service
@Transactional
public class ReverseauctionService {
	@Autowired
	private ReverseauctionMapper reverseauctionMapper;
	
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
		pageMaker.setAllCount(reverseauctionMapper.selectCountReverseauction());
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
		i+=reverseauctionMapper.deleteReverseauctionTender(reverseauctionNo);
		i+=reverseauctionMapper.deleteReverseauction(reverseauctionNo);
		return i;
	}
	// 8. 입찰 목록 조회 (역경매 내 조회)
	public List<ReverseauctionTender> getTenderListForOneReverseauction(int reverseauctionNo){
		System.out.println("ReverseauctionService.getTenderListForOneReverseauction()");
		return reverseauctionMapper.selectTenderListForOneReverseauction(reverseauctionNo);
	}
	// 9. 입찰 상세 조회
	public ReverseauctionTender getTenderDetail(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionService.getTenderDetail()");
		return reverseauctionMapper.selectReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 10. 입찰 등록
	public int addReverseauctionTender(ReverseauctionTender reverseauctionTender) {
		System.out.println("ReverseauctionService.addReverseauctionTender()");
		System.out.println("reverseauctionNo : "+reverseauctionTender.getReverseauctionNo());
		return reverseauctionMapper.insertReverseauctionTender(reverseauctionTender);
	}
	// 11. 입찰 수정 폼
	public ReverseauctionTender modifyReverseauctionTenderForm(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionService.modifyReverseauctionTender()");
		return reverseauctionMapper.selectReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 12. 입찰 수정 액션
	public int modifyReverseauctionTenderAction(ReverseauctionTender reverseauctionTender) {
		System.out.println("ReverseauctionService.modifyReverseauctionTenderAction()");
		System.out.println("reverseauctionNo : "+reverseauctionTender.getReverseauctionNo());
		
		return reverseauctionMapper.updateReverseauctionTender(reverseauctionTender);
	}
	// 13. 입찰 삭제
	public int removeReverseauctionTender(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionService.removeReverseauctionTender()");
		return reverseauctionMapper.deleteReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 14. 역경매 내 낙찰 조회
	public ReverseauctionSuccessfulbid getReverseauctionSuccessfulbid(int reverseauctionNo) {
		System.out.println("ReverseauctionService.getReverseauctionSuccessfulbid()");
		return reverseauctionMapper.selectReverseauctionSuccessfulbid(reverseauctionNo);
	}
	// 14. 낙찰 등록
	public int addReverseauctionSuccessfulbid(int reverseauctionTenderNo, int reverseauctionNo) {
		System.out.println("ReverseauctionService.addReverseauctionSuccessfulbid()");
		int i = 0;
		if(reverseauctionMapper.selectReverseauctionSuccessfulbid(reverseauctionNo) == null) {
			ReverseauctionSuccessfulbid reverseauctionSuccessfulbid = reverseauctionMapper.selectForSuccessfulbid(reverseauctionTenderNo);
			int price = reverseauctionMapper.selectReverseauctionTenderOne(reverseauctionTenderNo).getReverseauctionTenderPrice();
			reverseauctionSuccessfulbid.setReverseauctionSuccessfulbidPrice(price);
			reverseauctionMapper.insertReverseauctionSuccessfulbid(reverseauctionSuccessfulbid);
			i++;
		}
		return i;
	}
	// 15. 낙찰 취소
	public int cancelReverseauctionSuccessfulbid() {
		System.out.println("ReverseauctionService.cancelReverseauctionSuccessfulbid()");
		return 0;
	}
	// 16. 낙찰 삭제
	public int removeReverseauctionSuccessfulbid(int reverseauctionSuccessfulbidNo) {
		System.out.println("ReverseauctionService.removeReverseauctionSuccessfulbid()");
		reverseauctionMapper.deleteReverseauctionSuccessfulbid(reverseauctionSuccessfulbidNo);
		return 0;
	}
}
