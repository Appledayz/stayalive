package com.stay.alive.auction.reverse.vo;

import lombok.Data;

@Data
public class Reverseauction {
	private int reverseauctionNo;
	private String memberId;
	private String reverseauctionRegisterDate;
	private String reverseauctionUpdateDate;
	private String reverseauctionTenderLimit;
	private String reverseauctionTendercloseDate;
	private String reverseauctionRoomingDate;
	private String reverseauctionLeavingDate;
	private String reverseauctionTitle;
	private int reverseauctionNumberOfPeople;
	private String reverseauctionAddress;
	private String reverseauctionAddressMore;
	private int reverseauctionHits;
	private String reverseauctionContent;
	private int reverseauctionTenderCount;
	private int auctionStateCategoryNo;
	private String auctionStateCategoryName;
}
