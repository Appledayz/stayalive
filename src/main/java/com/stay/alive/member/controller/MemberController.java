package com.stay.alive.member.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.auction.reverse.service.ReverseauctionService;
import com.stay.alive.member.service.MemberService;
import com.stay.alive.member.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	//1-1.입력폼
	@GetMapping("/member/addMember")
	public String addMember() {		
		return "/member/addMember";
	}
	//1-2.입력액션 
	@PostMapping("/member/addMember")
	public String addMember(Member member) {
		memberService.addMember(member);
		return "/member/welcome";
	}
	//1-3.환영페이지로
	@GetMapping("/member/welcome")
	public String welcome() {
		return "/member/welcome";
	}
	//2.아이디 중복확인
		@ResponseBody
		@PostMapping("/idCheck")
		public int postIdCheck(Member memberId) {
			memberService.idCheck(memberId);
			Member idCheck = memberService.idCheck(memberId);
			int result = 0;
			if(idCheck !=null) {
				result = 1;
			}
			return result;
		}
	//3.닉네임 중복확인
	@ResponseBody
	@PostMapping("/nicknameCheck")
	public int postnicknameCheck(Member memberNickname) {
		memberService.nicknameCheck(memberNickname);
		Member nicknameCheck = memberService.nicknameCheck(memberNickname);
		int result2 = 0;
		if(nicknameCheck !=null) {
			result2 = 1;
		}
		return result2;
	}
	//페이징
	//1-2.회원가입 액션
	
	//2-1.회원정보 수정 폼
	
	//2-2.회원정보 수정 액션
	
	//3.회원 목록 조회
	
	//4.회원 탈퇴 신청
	
	
}
