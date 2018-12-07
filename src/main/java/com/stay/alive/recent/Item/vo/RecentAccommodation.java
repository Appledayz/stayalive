package com.stay.alive.recent.Item.vo;

import lombok.Data;

@Data
public class RecentAccommodation {

	private int recentAccommodationNo; // 최근 본 상품 숙소 번호(PK)
	private	String memberId; // 회원 아이디
	private int accommodationNo; // 숙소 등록 번호(FK)
	private String accommodationName; // 숙소명
	private String recentDate; // 쵀근 본 상품 등록 날짜	
	
}
