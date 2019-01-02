package com.stay.alive.member.state.vo;

import lombok.Data;

@Data
public class MemberState {
	
	private int stateNo; // 회원 그룹 번호(PK)
	private String stateName; // 그룹명
	private String stateRegisterDate; // 회원 그룹 등록일자

}
