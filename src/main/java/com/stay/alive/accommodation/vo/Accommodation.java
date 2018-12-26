package com.stay.alive.accommodation.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Accommodation {
	private String accommodationNo; //숙소 등록 번호(PK)
	private String memberId; //숙박 업체 회원 아이디
	private int companyNo; //업체 등록 번호(FK)
	private String companyName; //업체명
	private int accommodationCategoryNo; //숙소 카테고리 번호(FK)
	private String accommodationCategoryName; //숙소 카테고리 명
	private String accommodationName; //숙소명
	private double accommodationLatitude; //숙소 위도
	private double accommodationLongitude; //숙소 경도
	private String addressSidoName; //시/도 
	private String addressSigunguName; // 시/군/구 
	private String accommodationAddress; //숙소 주소
	//private int accommodationImageCount; //숙소 이미지 개수
	private String memberBusinessNumber; //사업자 번호
	private MultipartFile businessNumberFile; //사업자 번호 파일
	private int accommodationScore; //평점
	private int accommodationGuestroomTotal; //총 객실 수
	private String accommodationPhone; //숙소 연락처
	private String accommodationEmail; //숙소 이메일
	private String accommodationDetail; //세부내용
	private String accommodationRegisterDate; //숙소 등록일자
	private String accommodationUpdateDate; //마지막 숙소 등록정보 수정일
	private int imageFileNo; //사업자등록 파일 번호
}
