package com.stay.alive.auction.reverse.vo;

import lombok.Data;

@Data
public class ReverseauctionSuccessfulbid {
	private int reverseauctionSuccessfulbidNo;
	private int reverseauctionNo;
	private int reverseauctionTenderNo;
	private int guestroomOptionNo;
	private String guestroomOptionName;
	private int guestroomAdditionalPrice;
	private int reverseauctionSuccessfulbidPrice;
	private String reverseauctionSuccessfulbidDate;
	private String reverseauctionRoomingDate;
	private String reverseauctionLeavingDate;
	private int auctionStateCategoryNo;
	private String auctionStateCategoryName;
}
