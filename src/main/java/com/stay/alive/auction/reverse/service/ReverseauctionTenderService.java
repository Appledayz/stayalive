package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.accommodation.vo.Accommodation;
import com.stay.alive.auction.reverse.mapper.ReverseauctionTenderMapper;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;
import com.stay.alive.company.vo.Company;
import com.stay.alive.file.ImageFile;
import com.stay.alive.guestroom.vo.GuestRoom;

@Service
@Transactional
public class ReverseauctionTenderService {
	@Autowired
	private ReverseauctionTenderMapper reverseauctionTenderMapper;
	
	// 8. 입찰 목록 조회 (역경매 내 조회)
	public List<ReverseauctionTender> getTenderListForOneReverseauction(int reverseauctionNo){
		System.out.println("ReverseauctionTenderService.getTenderListForOneReverseauction()");
		return reverseauctionTenderMapper.selectTenderListForOneReverseauction(reverseauctionNo);
	}
	// 9. 입찰 상세 조회
	public ReverseauctionTender getTenderDetail(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionTenderService.getTenderDetail()");
		return reverseauctionTenderMapper.selectReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 10. 입찰 등록
	public int addReverseauctionTender(ReverseauctionTender reverseauctionTender) {
		System.out.println("ReverseauctionTenderService.addReverseauctionTender()");
		Company company = reverseauctionTenderMapper.selectCompany(reverseauctionTender.getMemberId());
		reverseauctionTender.setCompanyNo(company.getCompanyNo());
		reverseauctionTender.setCompanyName(company.getCompanyName());
		return reverseauctionTenderMapper.insertReverseauctionTender(reverseauctionTender);
	}
	// 11. 입찰 수정 폼
	public ReverseauctionTender modifyReverseauctionTenderForm(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionTenderService.modifyReverseauctionTender()");
		return reverseauctionTenderMapper.selectReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 12. 입찰 수정 액션
	public int modifyReverseauctionTenderAction(ReverseauctionTender reverseauctionTender) {
		System.out.println("ReverseauctionTenderService.modifyReverseauctionTenderAction()");
		System.out.println("reverseauctionNo : "+reverseauctionTender.getReverseauctionNo());
		
		return reverseauctionTenderMapper.updateReverseauctionTender(reverseauctionTender);
	}
	// 13. 입찰 삭제
	public int removeReverseauctionTender(int reverseauctionTenderNo) {
		System.out.println("ReverseauctionTenderService.removeReverseauctionTender()");
		return reverseauctionTenderMapper.deleteReverseauctionTenderOne(reverseauctionTenderNo);
	}
	// 14. 역경매입찰 카운트 +1
	public void plusReverseauctionTenderCount(int reverseauctionNo) {
		System.out.println("ReverseauctionTenderService.plusReverseauctionTenderCount()");
		reverseauctionTenderMapper.updateReverseauctionTenderCountUp(reverseauctionNo);
	}
	// 숙소이미지 조회
	public ImageFile getTenderAccommodationImg(int accommodationNo) {
		System.out.println("ReverseauctionTenderService.plusReverseauctionTenderCount()");
		return reverseauctionTenderMapper.selectAccommodationImg(accommodationNo);
	}
	// 자기 숙소 조회
	public List<Accommodation> getAccommodation(String memberId) {
		System.out.println("ReverseauctionTenderService.getAccommodation()");
		return reverseauctionTenderMapper.selectAccommodation(memberId);
	}
	public List<GuestRoom> getGuestRoom(int accommodationNo) {
		System.out.println("ReverseauctionTenderService.getGuestRoom()");
		return reverseauctionTenderMapper.selectGuestRooom(accommodationNo);
	}
	// 역경매입찰 카운트-1
	public void minusReverseauctionTenderCount(int reverseauctionNo) {
		System.out.println("ReverseauctionTenderService.minusReverseauctionTenderCount()");
		reverseauctionTenderMapper.updateReverseauctionTenderCountDown(reverseauctionNo);
	}
}
