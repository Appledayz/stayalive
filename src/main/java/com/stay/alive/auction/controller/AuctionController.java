package com.stay.alive.auction.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stay.alive.auction.dutch.service.DutchauctionBidService;
import com.stay.alive.auction.dutch.service.DutchauctionService;
import com.stay.alive.auction.reverse.service.ReverseauctionService;
import com.stay.alive.auction.reverse.service.ReverseauctionSuccessfulbidService;
import com.stay.alive.auction.reverse.service.ReverseauctionTenderService;
import com.stay.alive.auction.reverse.vo.Reverseauction;
import com.stay.alive.auction.reverse.vo.ReverseauctionTender;

@Controller
public class AuctionController {
	
	@Autowired
	DutchauctionBidService dutchauctionBidService;
	@Autowired
	ReverseauctionSuccessfulbidService reverseauctionSuccessfulbidService;
	@Autowired
	ReverseauctionService reverseauctionService;
	@Autowired
	DutchauctionService dutchauctionService;
	@Autowired
	ReverseauctionTenderService reverseauctionTenderService;
	
	@GetMapping("auction")
	public String auction() {
		return "auction/auction";
	}
	
	@GetMapping("myAuctionList")
	public String myAuctionList(Model model, HttpSession session, Reverseauction reverseauction, ReverseauctionTender reverseauctionTender) {
		String memberId = (String)session.getAttribute("memberId");
		String groupName = (String)session.getAttribute("groupName");
		reverseauction.setMemberId(memberId);
		reverseauctionTender.setMemberId(memberId);
		if(memberId == null) {
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/login");
			return "alert";
		} else if(groupName.equals("호스트") || groupName.equals("관리자")) {
			model.addAttribute("dutchauctionList", dutchauctionService.getDutchAuctionsFromId(memberId));
			model.addAttribute("dutchauctionSuccessfulbidList", dutchauctionBidService.getDutchauctionSuccessfulbidFromId(memberId, groupName));
			model.addAttribute("reverseauctionList", reverseauctionService.getReverseauctionListById(reverseauction));
			model.addAttribute("reverseauctionTenderList", reverseauctionTenderService.getReverseauctionTenderListById(reverseauctionTender));
			model.addAttribute("reverseauctionSuccessfulbidList", reverseauctionSuccessfulbidService.getReverseauctionSuccessfulbid(memberId, groupName));
			return "auction/myAuctionListOfHost";
		} else {
			model.addAttribute("dutchauctionSuccessfulbidList", dutchauctionBidService.getDutchauctionSuccessfulbidFromId(memberId, groupName));
			model.addAttribute("reverseauctionList", reverseauctionService.getReverseauctionListById(reverseauction));
			model.addAttribute("reverseauctionSuccessfulbidList", reverseauctionSuccessfulbidService.getReverseauctionSuccessfulbid(memberId, groupName));
			return "auction/myAuctionList";
		}
	}
	
}
