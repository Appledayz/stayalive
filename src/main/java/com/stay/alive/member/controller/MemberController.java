package com.stay.alive.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.member.service.MemberService;
import com.stay.alive.member.vo.Member;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	//1-1.입력폼
	@GetMapping("addMember")
	public String addMember() {		
		return "member/addMember";
	}
	//1-2.입력액션 
	@PostMapping("addMember")
	public String addMember(Member member) {
		memberService.addMember(member);
		return "member/welcome";
	}
	//1-3.환영페이지로
	@GetMapping("welcome")
	public String welcome() {
		return "member/welcome";
	}
	//1-4.아이디 중복확인
	@ResponseBody
	@PostMapping("idCheck")
	public int postIdCheck(Member memberId) {
		memberService.idCheck(memberId);
		Member idCheck = memberService.idCheck(memberId);
		int result = 0;
		if(idCheck !=null) {
			result = 1;
		}
		return result;
	}
	//1-5.닉네임 중복확인
	@ResponseBody
	@PostMapping("nicknameCheck")
	public int postnicknameCheck(Member memberNickname) {
		memberService.nicknameCheck(memberNickname);
		Member nicknameCheck = memberService.nicknameCheck(memberNickname);
		int result2 = 0;
		if(nicknameCheck !=null) {
			result2 = 1;
		}
		return result2;
	}
	//2-1 수정폼
	@GetMapping("modifyMember")
	public String modifyMember(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId == null) {
			return "/login/login";
		} else {
			Member member = memberService.getMember(memberId);
			model.addAttribute("member", member);
			System.out.println(member+"<-세션에서 넘어온 값");
			return "member/modifyMember";
		}
	}
	//2-2 수정액션
	@PostMapping("modifyMember")
	public String modifyMember(Member member) {
		if(memberService.modifyMember(member)==1) {
            System.out.println("수정 완료");
        }
		return "redirect:/main";
	}
	//페이징
	//1-2.회원가입 액션
	
	//2-1.회원정보 수정 폼
	
	//2-2.회원정보 수정 액션
	
	//3.회원 목록 조회
	
	//4.회원 탈퇴 신청
}
