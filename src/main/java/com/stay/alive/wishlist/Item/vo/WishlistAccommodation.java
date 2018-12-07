package com.stay.alive.wishlist.Item.vo;

import lombok.Data;

@Data
public class WishlistAccommodation {
	
	private int wishlistAccommodationNo; // 찜하기 숙소 번호(PK)
	private	String memberId; // 회원 아이디
	private int accommodationNo; // 숙소 등록 번호(FK)
	private String accommodationName; // 숙소명
	private String wishlistDate; // 찜한 날짜
	
}
