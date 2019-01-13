package com.stay.alive.auction.reverse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.auction.reverse.service.ReverseauctionSuccessfulbidService;
import com.stay.alive.auction.reverse.vo.ReverseauctionSuccessfulbid;

@Controller
@RequestMapping("auction/reverse/successfulbid")
public class ReverseauctionSuccessfulbidController {
	@Autowired
	private ReverseauctionSuccessfulbidService reverseauctionSuccessfulbidService;

	// 15. 낙찰 등록
	@GetMapping("add")
	public String addReverseauctionSuccessfulbid(Model model, int reverseauctionTenderNo, int reverseauctionNo) {
		System.out.println("ReverseauctionController.addReverseauctionSuccessfulbid() GET");
		int i = reverseauctionSuccessfulbidService.addReverseauctionSuccessfulbid(reverseauctionTenderNo, reverseauctionNo);
		if (i == 0) {
			return "redirect:/auction/reverse/detail?fail=true&reverseauctionNo=" + reverseauctionNo;
		}
		ReverseauctionSuccessfulbid reverseauctionSuccessfulbid = reverseauctionSuccessfulbidService.getReverseauctionSuccessfulbid(reverseauctionNo);
		model.addAttribute("paymentPrice", reverseauctionSuccessfulbid.getReverseauctionSuccessfulbidPrice());
		return "payment/payment";
	}

	// 16. 낙찰 삭제
	@GetMapping("remove")
	public String removeReverseauctionSuccessfulbid(int reverseauctionNo, int reverseauctionSuccessfulbidNo) {
		System.out.println("ReverseauctionController.removeReverseauctionSuccessfulbid() GET");
		reverseauctionSuccessfulbidService.removeReverseauctionSuccessfulbid(reverseauctionSuccessfulbidNo);
		return "redirect:/auction/reverse/detail?reverseauctionNo=" + reverseauctionNo;
	}
}
