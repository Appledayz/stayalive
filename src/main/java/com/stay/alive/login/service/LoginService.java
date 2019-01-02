package com.stay.alive.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.login.mapper.LoginMapper;
import com.stay.alive.login.vo.LoginVo;


@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;
	
	public LoginVo memberLogin(LoginVo loginVo) {
		System.out.println("LoginService.java");
		LoginVo loginMember = loginMapper.selectLogin(loginVo);
		System.out.println(loginMember+"<--loginMember");
		return loginMember;
	}
	public String getMemberSaltFromId(String memberId) {
		return loginMapper.selectMemberSaltFromId(memberId);
	}
}
