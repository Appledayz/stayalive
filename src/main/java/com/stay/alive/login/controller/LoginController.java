package com.stay.alive.login.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.stay.alive.login.service.LoginService;
import com.stay.alive.login.vo.LoginVo;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;

	//로그인 폼
	@GetMapping("")
	public String Login(HttpSession session) {
		String LoginCheck = null;
		if(session.getAttribute("sessionLogin")!=null) {
			LoginCheck = "redirect:/";
		}else {
			LoginCheck = "login/login";
		}
		return LoginCheck;
	}
	//로그인
	@PostMapping(value="/memberLogin")
	public String memberLogin(HttpSession session, LoginVo loginVo) throws IOException {
		System.out.println("LoginController.java");
		String LoginCheck = null;
		if(loginService.memberLogin(loginVo)!=null) {
			LoginVo sessionLogin = loginService.memberLogin(loginVo);
			session.setAttribute("sessionLogin", sessionLogin);		
			session.setAttribute("memberId", sessionLogin.getMemberId());
			System.out.println(sessionLogin.getMemberId() + "<--memberId");
			session.setAttribute("groupName", sessionLogin.getGroupName());
			System.out.println(sessionLogin.getGroupName() + "<--groupName");
			session.setAttribute("memberNickname", sessionLogin.getMemberNickname());
			System.out.println(sessionLogin.getMemberNickname() + "<--memberNickname");
			LoginCheck = "redirect:/main";
		}else {
			LoginCheck = "/login/login";
		}
		return LoginCheck;
	}
	//로그아웃
	@GetMapping(value = "/memberLogout")
	public String userLogout(HttpSession session) {
		System.out.println("LoginController.java");
		session.invalidate();
		return "redirect:/main";
	}
}