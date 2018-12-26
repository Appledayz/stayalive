package com.stay.alive.guestroom.vo;

import lombok.Data;

@Data
public class GuestRoom {
	private int guestroomNo;//객실 등록 번호
	private String memberId; //숙박 업체 회원 아이디
	private int companyNo; //업체 등록 번호(FK)
	private String companyName;//업체명
	private int accommodationNo;//숙소 등록 번호(FK)
	private String accommodationName;//숙소명
	private String guestroomName;//객실명
	private int guestroomBuyInstant;//즉시구매가(1박기준)
	private int guestroomCapacity;//수용인원
	private int guestroomSize;//방크기
	private String guestroomDetail;//세부내용
	private String guestroomRegisterDate;//객실등록일자
	private String guestroomUpdateDate;//마지막 객실 등록정보 수정일
	private int imageFileNo;//객실 이미지 번호
}
