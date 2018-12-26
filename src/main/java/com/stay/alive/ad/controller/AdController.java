package com.stay.alive.ad.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.ad.service.AdService;
import com.stay.alive.ad.vo.Ad;

@Controller
@RequestMapping("/ad")
public class AdController {
	@Autowired
	private AdService adService;
	
	// 광고 메인페이지
	@GetMapping("")
	public String ad() {
		return "/ad/ad";
	}
	// 광고 등록 폼
	@GetMapping(value="/adRegister")
	public String adRegister() {
		return "/ad/adRegister";
	}
	// 광고 등록 액션
	@PostMapping(value="/adRegister")
	public String adRegister(Ad ad,HttpSession session) {
		String memberId = "ID1";
		String path = session.getServletContext().getRealPath("/image/ad");
		ad.setMemberId(memberId);
		adService.addAd(ad, path);
		return "redirect:/ad";
	}
	
	@GetMapping("/adList")
	public String adList(Model model) {
		ArrayList<Ad> ad = adService.getAdAll();
		model.addAttribute("list", ad);
		return "ad/adList";
	}
}
