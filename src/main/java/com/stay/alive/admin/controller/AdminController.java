package com.stay.alive.admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.login.service.LoginService;
import com.stay.alive.login.vo.LoginVo;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("main")
	public String admin(Model model, HttpSession session) {
		if(session.getAttribute("groupName") == null) {
			model.addAttribute("msg", "관리자 로그인이 필요합니다.");
			model.addAttribute("url", "/admin/adminLogin");
			return "alert";
		}
		String groupName = (String)session.getAttribute("groupName");
		if(groupName.equals("관리자")) {
			return "admin/admin";
		} else {
			model.addAttribute("msg", "관리자 로그인이 필요합니다.");
			model.addAttribute("url", "/admin/adminLogin");
			return "alert";
		}
	}
	
	@GetMapping("adminLogin")
	public String adminLogin() {
		return "admin/adminLogin/adminLogin";
	}
	
	@PostMapping("adminLogin")
	public String memberLogin(Model model, HttpSession session, LoginVo loginVo) throws IOException {
		System.out.println("LoginController.java");
		if(loginService.memberLogin(loginVo)!=null) {
			LoginVo sessionLogin = loginService.memberLogin(loginVo);
			session.setAttribute("sessionLogin", sessionLogin);		
			session.setAttribute("memberId", sessionLogin.getMemberId());
			System.out.println(sessionLogin.getMemberId() + "<--memberId");
			session.setAttribute("groupName", sessionLogin.getGroupName());
			System.out.println(sessionLogin.getGroupName() + "<--groupName");
			session.setAttribute("memberNickname", sessionLogin.getMemberNickname());
			System.out.println(sessionLogin.getMemberNickname() + "<--memberNickname");
			return "redirect:/admin/main";
		}else {
			model.addAttribute("msg", "관리자 로그인이 필요합니다.");
			model.addAttribute("url", "/admin/adminLogin");
			return "alert";
		}
	}
	
	@GetMapping("adminLogout")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
