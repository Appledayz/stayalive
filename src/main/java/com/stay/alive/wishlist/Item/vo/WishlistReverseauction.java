package com.stay.alive.wishlist.Item.vo;

import lombok.Data;

@Data
public class WishlistReverseauction {
	
	private int wishlistReverseauctionNo; // 찜하기 역경매 번호(PK)
	private String memberId; // 회원 아이디
	private int reverseauctionNo; // 역경매 번호(FK)
	private String wishlistDate; // 찜한 날짜
	
}
