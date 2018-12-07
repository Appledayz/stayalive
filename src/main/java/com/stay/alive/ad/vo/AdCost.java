package com.stay.alive.ad.vo;

import lombok.Data;

@Data
public class AdCost {
	// 광고 단가
	private int adCostNo; //광고 단가 번호(PK)
	private String adCostType; //광고 타입
	private int adCostPerday; //1일당 광고 단가
	private String adCostSize; //광고 면적
}
