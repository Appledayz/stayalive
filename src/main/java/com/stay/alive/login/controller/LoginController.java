package com.stay.alive.login.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.login.service.LoginService;
import com.stay.alive.member.vo.Member;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	//로그인 폼
	@GetMapping("")
	public String login(){
		return "/login/login";
	}
	//로그인
	@PostMapping(value="/memberLogin")
	public String memberLogin(HttpSession session, Member member) throws IOException {
		System.out.println("LoginController.java");
		int result = loginService.memberLogin(member);
		System.out.println(result+"<--result");
		if(result == 1) {
			session.setAttribute("memberId", member.getMemberId());
			System.out.println(member.getMemberId() + "<--memberId");
			return "redirect:/main";
		}else {
			return "/login/login";
		}
	}
	//로그아웃
	@GetMapping(value = "/memberLogout")
	public String userLogout(HttpSession session) {
		System.out.println("LoginController.java");
		session.invalidate();
		return "redirect:/main";
	}
}
