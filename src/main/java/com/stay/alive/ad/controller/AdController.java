package com.stay.alive.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stay.alive.ad.service.AdService;

@Controller
public class AdController {
	@Autowired
	private AdService adService;
	
	// 1. 광고 신청
	
	// 1.1 광고 등록 폼
	
	
	
	// 2. 광고 수정 폼
	
	// 2.1 광고 수정 액션
	
	// 3. 광고 삭제
	
	// 4. 광고 조회
	@GetMapping("adList")
	public String adList(Model model) {
		System.out.println("AdController.adList() GET");
		model.addAttribute("list", adService.getAdAll());
		return "adList";
	}
}
