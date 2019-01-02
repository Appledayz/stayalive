package com.stay.alive.auction.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stay.alive.auction.dutch.service.DutchauctionBidService;

@Controller
public class AuctionController {
	
	@Autowired
	DutchauctionBidService dutchauctionBidService;
	
	@GetMapping("auction")
	public String auction() {
		return "auction/auction";
	}
	
	@GetMapping("myAuctionList")
	public String myAuctionList(Model model, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		String groupName = (String)session.getAttribute("groupname");
		if(memberId == null) {
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/login");
			return "alert";
		} else {
			model.addAttribute("dutchauctionSuccessfulbidList", dutchauctionBidService.getDutchauctionSuccessfulbidFromId(memberId, groupName));
			return "auction/myAuctionList";
		}
	}
	
}
