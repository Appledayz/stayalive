package com.stay.alive.member.group.vo;

import lombok.Data;

@Data
public class MemberGroup {
	
	private int groupNo; // 회원 그룹 번호(PK)
	private String groupName; // 그룹명
	private String groupRegisterDate; // 회원 그룹 등록일자

}
