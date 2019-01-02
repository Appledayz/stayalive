package com.stay.alive.auction.reverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.auction.reverse.mapper.ReverseauctionSuccessfulbidMapper;
import com.stay.alive.auction.reverse.mapper.ReverseauctionTenderMapper;
import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;
import com.stay.alive.auction.vo.AuctionStateCategory;

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
			// 역경매, 입찰 테이블과 연결되는 정보를 낙찰 테이블에 때려넣습니다.
			ReverseauctionSuccessfulbid reverseauctionSuccessfulbid = reverseauctionSuccessfulbidMapper.selectForSuccessfulbid(reverseauctionTenderNo);
			// 가격 칼럼명은 서로 달라서 입찰정보에서 수동으로 받습니다.
			int price = reverseauctionTenderMapper.selectReverseauctionTenderOne(reverseauctionTenderNo).getReverseauctionTenderPrice();
			reverseauctionSuccessfulbid.setReverseauctionSuccessfulbidPrice(price);
			// 낙찰 테이블에 등록
			reverseauctionSuccessfulbidMapper.insertReverseauctionSuccessfulbid(reverseauctionSuccessfulbid);
			// 경매 상태 업데이트
			AuctionStateCategory auctionStateCategory = reverseauctionSuccessfulbidMapper.selectAuctionStateByName("낙찰완료");
			reverseauctionSuccessfulbidMapper.updateReverseauctionState(reverseauctionNo, auctionStateCategory);
			reverseauctionSuccessfulbidMapper.updateReverseauctionTenderState(reverseauctionTenderNo, auctionStateCategory);
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
	
	// 낙찰목록 조회 (memberId로)
	public List<ReverseauctionSuccessfulbid> getReverseauctionSuccessfulbid(String memberId, String groupName) {
		System.out.println("ReverseauctionService.getReverseauctionSuccessfulbid()");
		if(groupName.equals("구매자")) {
			return reverseauctionSuccessfulbidMapper.getSuccessfulbidByGuestId(memberId);
		}
		if(groupName.equals("판매자") || groupName.equals("관리자")) {
			return reverseauctionSuccessfulbidMapper.getSuccessfulbidByHostId(memberId);
		}else {
			return null;
		}
	}
}
