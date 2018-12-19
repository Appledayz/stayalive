package com.stay.alive.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.login.mapper.LoginMapper;
import com.stay.alive.member.vo.Member;


@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginMapper loginMapper;
	
	public int memberLogin(Member member) {
		System.out.println("LoginService.java");
		return loginMapper.memberLogin(member);
	}
}
