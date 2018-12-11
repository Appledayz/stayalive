package com.stay.alive.ad.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stay.alive.ad.service.AdService;
import com.stay.alive.ad.vo.Ad;

@Controller
public class AdController {
	@Autowired
	private AdService adService;
	
	// 1. 광고 전체 목록
	@GetMapping("/Ad/adList")
	public String adList(Model model) {
		System.out.println("AdController.adList() GET");

		model.addAttribute("list", adService.getAdList());
		return "/Ad/adList";
	}
	// 2.광고 목록 검색
	@GetMapping("adSearchList")
	public String adSearchList(Model model, @RequestParam HashMap<String, String> paraMap) {
		System.out.println("AdController.adSearchList() GET");
		String sk = paraMap.get("sk");
		String sv = paraMap.get("sv");
		sk= "member_id";
		sv= "0";
		model.addAttribute("list", adService.getAdSearchList(sk, sv));
		return "adList";
		/*model.addAttribute("list", adService.getAdAll());
		return "AdList";*/
	}
	// 3.광고 상세 보기
	@GetMapping("/Ad/adDetail")
	public String adDetail(Model model, int adRegisterNo) {
		System.out.println("AdController.adDetail() GET");
		model.addAttribute("ad", adService.getAdDetail(adRegisterNo));
		return "/Ad/adDetail";
	}
	// 4.광고 등록 폼
	@GetMapping("/Ad/addAd")
	public String addAd() {
		System.out.println("AdController.addAd() GET");
		return "/Ad/addAd";
	}
	/*// 5.광고 등록 액션
	@GetMapping("addAd")
	public String addAd(Ad ad) {
		System.out.println("AdController.addAd() POST");
		adService.addAdForm(ad);
		return "redirect:/adList";
	}*/
	// 6.광고 수정 폼
	@GetMapping("modifyAd")
	public String modifyAd(Model model, int adRegisterNo) {
		System.out.println("AdController.modifyAd() GET");
		model.addAttribute("Ad", adService.modifyAdForm(adRegisterNo));
		return "modifyAd";
	}
	/*// 7.광고 수정 액션
	@GetMapping("modifyAd")
	public String modifyAd(Ad ad) {
		System.out.println("AdController.modifyAd() POST");
		return "redirect:/adDetail?adRegisterNo="+ad.getAdRegisterNo();
	}*/
	// 8. 광고 삭제
	@GetMapping("removeAd")
	public String deleteAd() {
		System.out.println("AdController.removeAd() GET");
		return "";
	}
}
