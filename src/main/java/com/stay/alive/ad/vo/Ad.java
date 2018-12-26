package com.stay.alive.ad.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ad {
	// 광고 등록
	private int adRegisterNo; // 광고 등록 번호
	private String memberId; //숙박 업체 회원 아이디
	private String adRegisterName; //광고 이름
	private String adRegisterDate; //광고 신청일
	private String adRegisterConfirm; //광고 승인일
	private int adCostNo; //광고 단가 번호(FK)
	private String adRegisterStart; //시작시간
	private String adRegisterEnd; //마감시간
	private String adRegisterPost; //광고 게시 유무
	private int adGroupNo; //광고 그룹 번호(PK)
	private int adRegisterView; //노출수
	private int adRegisterClick; //클릭수
	private String adUpdateDate; //광고 수정일
	private MultipartFile File; //등록  파일
	private int adFileNo; // 광고 파일 번호
}
