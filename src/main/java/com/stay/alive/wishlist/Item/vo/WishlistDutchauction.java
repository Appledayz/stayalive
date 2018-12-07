package com.stay.alive.wishlist.Item.vo;

import lombok.Data;

@Data
public class WishlistDutchauction {
 
	private int wishlistDutchauctionNo; // 찜하기 네덜란드식 경매 번호(PK)
	private String memberId; // 회원 아이디
	private int dutchauctionNo; // 네덜란드식 경매 번호(FK)
	private String wishlistDate; // 찜한 날짜
	
}
