package com.stay.alive.ad.vo;

import lombok.Data;

@Data
public class Ad {
	// 광고 등록
	private String memberId; //숙박 업체 회원 아이디
	private int adRegisterDate; //광고 신청일
	private int adRegisterConfirm; //광고 승인일
	private int adCostNo; //광고 단가 번호(FK)
	private int adRegisterStart; //시작시간
	private int adRegisterEnd; //마감시간
	private String adRegisterPost; //광고 게시 유무
	private int adGroupNo; //광고 그룹 번호(PK)
	private String adGroupName; //그룹명
	private String adRegisterLink; //광고링크
	private int adRegisterView; //노출수
	private int adRegisterClick; //클릭수
	private String adUpdateDate; //광고 수정일
	
	// 광고 파일
	private int ad_register_no; //광고 등록 번호(FK)
	private String adFilePath; //파일경로
	private String adFileName; //파일이름
	private String adFileExtension; //파일확장자
	private String adFileForm; //파일형식
	private int adFileSize; //파일크기
	private String adFileDate; //파일등록일
	
	// 광고 단가
	private String adCostType; //광고 타입
	private int adCostPerday; //1일당 광고 단가
	private String adCostSize; //광고 면적
	
	// 광고 그룹
	private String adGroupDate; //그룹 등록일자
	private int adGroupCost; //광고 위치 단가
	
	// 광고 환불
	private String adRefundApplicationDate; //환불 신청일
	private String advertisementRefundState; //환불 상태
}
