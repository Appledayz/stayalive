package com.stay.alive.member.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stay.alive.member.service.MemberService;
import com.stay.alive.member.vo.Member;


public class MemberController {
	
	//1-1.회원가입 폼
	//3-1.입력폼
		@GetMapping("/member/addMember")
		public String addSample() {		
			return "member/addMember";
			// jquery, bootstrap, command객체
		
		}
		//3-2.입력액션
		@PostMapping("addMember")
		public String addMember(Member member, int memberNo) {
			Member member = MemberService.getMember(memberNo);
			model.addAttribute("member", member);
			return "addMemberList";
		}
	//1-2.회원가입 액션
	
	//2-1.회원정보 수정 폼
	
	//2-2.회원정보 수정 액션
	
	//3.회원 목록 조회
	
	//4.회원 탈퇴 신청
	
	
}
