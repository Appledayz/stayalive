package com.stay.alive.auction.reverse.vo;

import lombok.Data;

@Data
public class ReverseauctionTender {
	private int reverseauctionTenderNo;
	private String memberId;
	private int companyNo;
	private String companyName;
	private int accommodationNo;
	private String accommodationName;
	private int guestroomNo;
	private String guestroomName;
	private int reverseauctionNo;
	private int accommodationGuestroomAllcount;
	private int guestroomStateCount;
	private String reverseauctionTenderDate;
	private String reverseauctionTenderUpdateDate;
	private String reverseauctionTenderContent;
	private int reverseauctionTenderPrice;
	private int auctionStateCategoryNo;
	private String auctionStateCategoryName;
}
