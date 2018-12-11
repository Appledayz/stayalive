package com.stay.alive.member.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.member.mapper.MemberMapper;
import com.stay.alive.member.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	//1.회원추가
	public int addMember(Member member) {
		System.out.println("MemberController.addMember 요청 받음");
		return memberMapper.insertMember(member);
	}
}