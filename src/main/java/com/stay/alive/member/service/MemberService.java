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
	//2.아이디 중복확인
	public Member idCheck(Member memberId) {
		return memberMapper.idCheck(memberId);
	}
	//3.닉네임 중복확인
	public Member nicknameCheck(Member memberNickname) {
		return memberMapper.nicknameCheck(memberNickname);
	}
}