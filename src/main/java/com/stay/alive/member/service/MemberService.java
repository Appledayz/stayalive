package com.stay.alive.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.common.SHA256Util;
import com.stay.alive.member.mapper.MemberMapper;
import com.stay.alive.member.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	//1-1.회원추가
	public int addMember(Member member) {
		System.out.println("MemberController.addMember 요청 받음");
		String salt = SHA256Util.generateSalt();
		member.setSalt(salt);
		String passWord = member.getMemberPassword();
		passWord = SHA256Util.getEncrypt(passWord, salt);
		member.setMemberPassword(passWord);
		return memberMapper.insertMember(member);
	}
	//1-2.아이디 중복확인
	public Member idCheck(Member memberId) {
		return memberMapper.idCheck(memberId);
	}
	//1-3.닉네임 중복확인
	public Member nicknameCheck(Member memberNickname) {
		return memberMapper.nicknameCheck(memberNickname);
	}
	//2-1 셀렉트 아이디 (수정 폼, 탈퇴폼)
	public Member getMember(String memberId) {
		return memberMapper.selectOne(memberId);
	}
	//2-2 수정액션
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}
	//3-2 삭제액션
	public int removeMember(Member member) {
		return memberMapper.deleteMember(member);
	}
	public int getMemberGroupNoFromId(String memberId) {
		return memberMapper.selectMemberGroupNoFromId(memberId);
	}
}