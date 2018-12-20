package com.stay.alive.auction.reverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.auction.reverse.service.ReverseauctionService;
import com.stay.alive.auction.reverse.service.ReverseauctionTenderService;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

@Controller
@RequestMapping("auction/reverse/tender")
public class ReverseauctionTenderController {
	@Autowired
	private ReverseauctionService reverseauctionService;
	@Autowired
	private ReverseauctionTenderService reverseauctionTenderService;
	
	// 9. 역경매 입찰 상세 조회 (역경매 내 조회)
		@GetMapping("detail")
		public String reverseauctionTenderDetail(int reverseauctionTenderNo) {
			reverseauctionTenderService.getTenderDetail(reverseauctionTenderNo);
			return "/reverseauction/reverseauctionTenderDetail";
		}
		// 10. 역경매 입찰 등록 폼
		@GetMapping("add")
		public String addReverseauctionTender(ReverseauctionTender reverseauctionTender) {
			System.out.println("ReverseauctionController.addReverseauctionTender() GET");
			return "/reverseauction/addReverseauctionTender";
		}
		// 11. 역경매 입찰 등록 액션
		@PostMapping("add")
		public String addReverseauctionTenderAction(ReverseauctionTender reverseauctionTender) {
			reverseauctionTenderService.addReverseauctionTender(reverseauctionTender);
			reverseauctionTenderService.plusReverseauctionTenderCount(reverseauctionTender.getReverseauctionNo());
			return "redirect:/auction/reverse/detail?reverseauctionNo="+reverseauctionTender.getReverseauctionNo();
		}
		// 12. 역경매 입찰 수정 폼
		@GetMapping("modify")
		public String modifyReverseauctionTender() {
			System.out.println("ReverseauctionController.modifyReverseauctionTender() GET");
			return "/reverseauction/modifyReverseauctionTender";
		}
		// 13. 역경매 입찰 수정 액션
		@PostMapping("modify")
		public String modifyReverseauctionTender(ReverseauctionTender reverseauctionTender) {
			System.out.println("ReverseauctionController.modifyReverseauctionTender() POST");
			return "redirect:/auction/reverse/detail?reverseauctionNo="+reverseauctionTender.getReverseauctionNo();
		}
		// 14. 역경매 입찰 삭제
		@GetMapping("remove")
		public String deleteReverseauctionTender(int reverseauctionTenderNo, int reverseauctionNo) {
			System.out.println("ReverseauctionController.deleteReverseauctionTender() GET");
			reverseauctionTenderService.removeReverseauctionTender(reverseauctionTenderNo);
			return "redirect:/auction/reverse/detail?reverseauctionNo="+reverseauctionNo;
		}
}
