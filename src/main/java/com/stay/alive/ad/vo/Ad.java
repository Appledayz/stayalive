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
}
