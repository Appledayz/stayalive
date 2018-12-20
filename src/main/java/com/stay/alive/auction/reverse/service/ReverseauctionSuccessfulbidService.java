package com.stay.alive.auction.reverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionSuccessfulbidMapper;
import com.stay.alive.auction.reverse.mapper.ReverseauctionTenderMapper;
import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;

@Service
@Transactional
public class ReverseauctionSuccessfulbidService {
	@Autowired
	private ReverseauctionSuccessfulbidMapper reverseauctionSuccessfulbidMapper;
	@Autowired
	private ReverseauctionTenderMapper reverseauctionTenderMapper;

	// 14. 역경매 내 낙찰 조회
	public ReverseauctionSuccessfulbid getReverseauctionSuccessfulbid(int reverseauctionNo) {
		System.out.println("ReverseauctionService.getReverseauctionSuccessfulbid()");
		return reverseauctionSuccessfulbidMapper.selectReverseauctionSuccessfulbid(reverseauctionNo);
	}

	// 14. 낙찰 등록
	public int addReverseauctionSuccessfulbid(int reverseauctionTenderNo, int reverseauctionNo) {
		System.out.println("ReverseauctionService.addReverseauctionSuccessfulbid()");
		int i = 0;
		if (reverseauctionSuccessfulbidMapper.selectReverseauctionSuccessfulbid(reverseauctionNo) == null) {
			ReverseauctionSuccessfulbid reverseauctionSuccessfulbid = reverseauctionSuccessfulbidMapper.selectForSuccessfulbid(reverseauctionTenderNo);
			int price = reverseauctionTenderMapper.selectReverseauctionTenderOne(reverseauctionTenderNo).getReverseauctionTenderPrice();
			reverseauctionSuccessfulbid.setReverseauctionSuccessfulbidPrice(price);
			reverseauctionSuccessfulbidMapper.insertReverseauctionSuccessfulbid(reverseauctionSuccessfulbid);
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
		reverseauctionSuccessfulbidMapper.deleteReverseauctionSuccessfulbid(reverseauctionSuccessfulbidNo);
		return 0;
	}
}
