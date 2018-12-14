package com.stay.alive.ad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stay.alive.ad.service.AdService;
import com.stay.alive.ad.vo.Ad;

@Controller
public class AdController {
	@Autowired
	private AdService adService;
	// 광고 메인페이지
	@GetMapping("ad")
	public String ad() {
		return "/Ad/ad";
	}
	@GetMapping("adRegister")
	public String adRegister() {
		return "/Ad/adRegister";
	}
	@PostMapping("adRegister")
	public String adRegister(Ad ad,HttpSession session) {
		String contextPath = session.getServletContext().getRealPath("/upload/images");
		adService.adRegister(ad, contextPath);
		return "redirect:/ad";
	}
}
