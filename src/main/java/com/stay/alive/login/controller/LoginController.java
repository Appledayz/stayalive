package com.stay.alive.login.controller;

import java.io.IOException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.common.SHA256Util;
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
		LoginVo sessionLogin = null;
		String salt = loginService.getMemberSaltFromId(loginVo.getMemberId()); // 아이디가 없으면 null값이 들어간다
		if(salt != null) {
			String passWord = loginVo.getMemberPassword();
			passWord = SHA256Util.getEncrypt(passWord, salt);
			loginVo.setMemberPassword(passWord);
			sessionLogin = loginService.memberLogin(loginVo);
		}
		if(sessionLogin != null) {
			session.setAttribute("sessionLogin", sessionLogin);		
			session.setAttribute("memberId", sessionLogin.getMemberId());
			System.out.println(sessionLogin.getMemberId() + "<--memberId");
			session.setAttribute("groupName", sessionLogin.getGroupName());
			System.out.println(sessionLogin.getGroupName() + "<--groupName");
			session.setAttribute("memberNickname", sessionLogin.getMemberNickname());
			System.out.println(sessionLogin.getMemberNickname() + "<--memberNickname");
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