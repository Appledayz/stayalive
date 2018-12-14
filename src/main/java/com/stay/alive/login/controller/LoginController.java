package com.stay.alive.login.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	//로그인
	@GetMapping("login")
	public String login(){
		return "/login";
	}
	
	//로그인(리다이렉트)
	@GetMapping("receiveCode")
	public String receiveCode() {
		return "/receiveCode";
	}
}
