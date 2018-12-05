package com.stay.alive.auction.reverse.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stay.alive.auction.reverse.service.ReverseauctionService;
import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

@Controller
public class ReverseauctionController {
	@Autowired
	private ReverseauctionService reverseauctionService;
	
	// 1. 역경매목록 조회
	@GetMapping("reverseauctionList")
	public String reverseauctionList(Model model) {
		System.out.println("ReverseauctionController.reverseauctionList() GET");
		model.addAttribute("list", reverseauctionService.getReverseauctionAll());
		return "reverseauctionList";
	}
	// 2. 역경매목록 검색
	@GetMapping("reverseauctionSearchList")
	public String reverseauctionSearchList(Model model,@RequestParam HashMap<String, String> paraMap) {
		System.out.println("ReverseauctionController.reverseauctionList() GET");
		String sk = paraMap.get("sk");
		String sv = paraMap.get("sv");
		sk="member_id";
		sv="0";
		model.addAttribute("list", reverseauctionService.getReverseauctionSearchList(sk, sv));
		return "reverseauctionList";
	}
	// 3. 역경매 등록 폼
	@GetMapping("addReverseauction")
	public String addReverseauction() {
		System.out.println("ReverseauctionController.addReverseauction() GET");
		return "addReverseauction";
	}
	// 4. 역경매 등록 액션
	@PostMapping("addReverseauction")
	public String addReverseauction(Reverseauction reverseauction) {
		System.out.println("ReverseauctionController.addReverseauction() POST");
		reverseauctionService.addReverseauctionOne(reverseauction);
		return "redirect:/reverseauctionList";
	}
	// 5. 역경매 상세 조회
	@GetMapping("reverseauctionDetail")
	public String reverseauctionDetail() {
		return "";
	}
	// 6. 역경매 수정 폼
	@GetMapping("modifyReverseauction")
	public String modifyReverseauction() {
		return "";
	}
	// 7. 역경매 수정 액션
	@PostMapping("modifyReverseauction")
	public String modifyReverseauction(Reverseauction reverseauction) {
		return "";
	}
	// 8. 역경매 삭제
	@GetMapping("removeReverseauction")
	public String deleteReverseauction() {
		return "";
	}
	// 9. 역경매 입찰 등록
	@GetMapping("addReverseauctionTender")
	public String addReverseauctionTender() {
		return "";
	}
	// 10. 역경매 입찰 수정 폼
	@GetMapping("modifyReverseauctionTender")
	public String modifyReverseauctionTender() {
		return "";
	}
	// 11. 역경매 입찰 수정 액션
	@PostMapping("modifyReverseauctionTender")
	public String modifyReverseauctionTender(ReverseauctionTender reverseauctionTender) {
		return "";
	}
	// 12. 역경매 입찰 삭제
	@GetMapping("removeReverseauctionTender")
	public String deleteReverseauctionTender() {
		return "";
	}
	// 13. 낙찰 등록
	@GetMapping("addReverseauctionSuccessfulbid")
	public String addReverseauctionSuccessfulbid() {
		return "";
	}
	// 14. 낙찰 취소
	@GetMapping("removeReverseauctionSuccessfulbid")
	public String removeReverseauctionSuccessfulbid() {
		return "";
	}
	// 15. 
}
