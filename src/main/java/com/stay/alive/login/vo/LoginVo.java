package com.stay.alive.login.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginVo {
	private String memberId;
	private String memberPassword;
	private String groupName;
	private int groupNo;
	private String memberNickname;
}
