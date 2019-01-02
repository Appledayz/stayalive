package com.stay.alive.member.option.vo;

import lombok.Data;

@Data
public class MemberOption {
	
	private int memberOptionNo; // 회원 옵션 번호(PK)
	private String memberOptionName; // 옵션명
	private String memberOptionDetail; // 회원 옵션 등록일자
	private String memberOptionDate; // 회원 옵션 등록일자

}
