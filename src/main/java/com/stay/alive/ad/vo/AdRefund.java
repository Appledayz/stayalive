package com.stay.alive.ad.vo;

import lombok.Data;

@Data
public class AdRefund {
	// 광고 환불
	private int adRefundNo; //광고 환불 번호(PK)
	private int adNo; //광고 번호(FK)
	private String adRefundApplicationDate; //환불 신청일
	private String advertisementRefundState; //환불 상태
}
