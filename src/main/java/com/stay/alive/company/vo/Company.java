package com.stay.alive.company.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
	private int companyNo; //업체 등록 번호(PK)
	private String companyName; //업체명
	private String companyHomepage; //업체 홈페이지
	private String companyAddress; //업체 주소
	private String memberId; //숙박 업체 회원 아이디
	private int ratingNo; //회원 등급 번호(FK)
	private String ratingName; //등급명
	private int companyVolume; //업체 거래량
	private int memberOptionNo; //회원옵션번호(FK)
	private String memberOptionName; //옵션명
	private int registerSalespostTotal; //등록한 판매 게시물 수
	private int registerAccommodationCount; //등록한 숙박시설 수
	private int reverseauctionRegisterCount; //현재 역경매 입찰 현황(역경매 등록현황)
	private int reverseauctionSuccessfulbidCount; //역경매 낙찰횟수
	private int dutchauctionRegisterCount; //네덜란드식 경매 등록 현황
	private int dutchauctionSalesCount; //네덜란드식 경매 통한 판매량
	private int companyWishlistCount; //찜한 사람수
	private String companyRecognition; //업체 승인 유무
	private String companyRegisterDate; //업체 등록일자
	private String companyUpdateDate; //마지막 업체 등록정보 수정일
	private MultipartFile imageFile; //등록 이미지 파일
}
