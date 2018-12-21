package com.stay.alive.auction.dutch.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dutchauction {
	private int dutchauctionNo;
	private String memberId;
	private String companyName;
	private String accommodationNo;
	private String accommodationName;
	private int guestroomNo;
	private String guestroomName;
	private String dutchauctionRegisterDate;
	private int dutchauctionStartprice;
	private int dutchauctionUpdatePrice;
}
