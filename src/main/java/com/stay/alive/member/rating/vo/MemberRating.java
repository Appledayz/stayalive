package com.stay.alive.member.rating.vo;

import lombok.Data;

@Data
public class MemberRating {
	
	private int ratingNo; // 회원 그룹 번호(PK)
	private String ratingName; // 그룹명
	private String ratingRegisterDate; // 회원 그룹 등록일자
	private String buyerYearVolume;
	private String sellerYearVolume;
}
