package com.stay.alive.ad.vo;

import lombok.Data;

@Data
public class AdGroup {
	// 광고 그룹
	private int adGroupNo; //광고 그룹 번호(PK)
	private String adGroupName; //그룹명
	private String adGroupDate; //그룹 등록일자
	private int adGroupCost; //광고 위치 단가
}
