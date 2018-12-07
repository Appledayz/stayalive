/*package com.stay.alive.member.service;

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
	public int addMemberOne(Member member) {
		return memberMapper.insertMember(member);
	}
	//2.회원조회
	public List<Member> getMemberAll() {
		return memberMapper.selectMemberAll();
	}
	
}*/