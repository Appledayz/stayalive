package com.stay.alive.recent.Item.vo;

import lombok.Data;

@Data
public class RecentDutchauction {

	private int recentDutchauctionNo; // 최근 본 상품 네덜란드식 경매 번호(PK)
	private String memberId; // 회원 아이디
	private int dutchauctionNo; // 네덜란드식 경매 번호(FK)
	private String recentDate; // 최근 본 상품 등록 날짜
	
}
