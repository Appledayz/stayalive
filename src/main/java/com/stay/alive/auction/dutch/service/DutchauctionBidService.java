package com.stay.alive.auction.dutch.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stay.alive.auction.dutch.mapper.DutchauctionBidMapper;
import com.stay.alive.auction.dutch.vo.DutchAuctionBid;

@Service
public class DutchauctionBidService {
	@Autowired
	DutchauctionBidMapper dutchauctionBidMapper;
	ArrayList<DutchAuctionBid> getDutchauctionSuccessfulbidFromId(String memberId) {
		return dutchauctionBidMapper.selectDutchauctionSuccessfulbidFromId(memberId);
	}
}
