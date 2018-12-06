package com.stay.alive.accommodation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Accommodation {
	private String memberId; //숙박 업체 회원 아이디
	private int companyNo; //업체 등록 번호(FK)
	private String companyName; //업체명
	private int accommodationCategoryNo; //숙소 카테고리 번호(FK)
	private String accommodationCategoryName; //숙소 카테고리 명
	private String accommodationName; //숙소명
	private int accommodationLatitude; //숙소 위도
	private int accommodationHardness; //숙소 경도
	private String addressDoNo; //도 번호(FK)
	private String addressSiNo; //시 번호(FK)
	private String addressGuNo; //구 번호(FK)
	private String accommodationAddress; //숙소 주소
	private int accommodationImageCount; //숙소 이미지 개수
	private String memberBusinessNumber; //사업자 번호
	private String accommodationConstructionDate; //건축일
	private int accommodationScore; //평점
	private int accommodationGuestroomTotal; //총 객실 수
	private String accommodationPhone; //숙소 연락처
	private String accommodationEmail; //숙소 이메일
	private String accommodationDetail; //세부내용
	private String accommodationRegisterDate; //숙소 등록일자
	private String accommodationUpdateDate; //마지막 숙소 등록정보 수정일
}
