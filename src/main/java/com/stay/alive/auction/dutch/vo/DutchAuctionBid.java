package com.stay.alive.auction.dutch.vo;

import lombok.Data;

@Data
public class DutchAuctionBid {
	int dutchauctionSuccessfulbidNo;
	int dutchauctionRegisterNo;
	private String memberId; //회원 아이디
	int dutchauctionSuccessfulbidPrice;
	String dutchauctionSuccessfulbidDate;
	String dutchauctionCheckinDate;
	String dutchauctionChechoutDate;
	int guestroomOptionNo;
	String guestroomOptionName;
	int auctionStateCategoryNo;
	String auctionStateCategoryName;
}
