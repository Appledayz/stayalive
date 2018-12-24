package com.stay.alive.auction.dutch.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DutchAuction {
	private int dutchauctionNo; //네덜란드식 경매 등록 번호(PK)
	private String memberId; //회원 아이디
	private String companyNo; //업체 등록번호(FK)
	private String companyName; // 업체명
	private int accommodationNo; //업체 등록번호(FK)
	private String accommodationName; //숙소명
	private int guestroomNo;//객실 등록번호(FK)
	private String guestroomName;//객실명
	private String dutchauctionRegisterDate;//등록일
	private int dutchauctionStartprice;//경매 시작가
	private int maximumDiscountPrice;//최대 할인가
	private int dutchauctionSaleUnit;//시간당 할인가
	private int dutchauctionSaleInterval;//할인단위(시간)
	private int dutchauctionCurentPrice;//현재가
	private int dutchauctionUpdatePrice;//최근 변동 가격
	private String dutchauctionCloseDate;//경매 종료일
	private String dutchauctionCheckinDate;//숙소 입실일
	private String dutchauctionCheckoutDate;//숙소 퇴실일
	private int auctionStateCategoryNo;//경매 상태 카테고리 번호(FK)
	private String auctionStateCategoryName;//상태 카테고리명

}
