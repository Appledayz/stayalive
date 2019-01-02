package com.stay.alive;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stay.alive.auction.dutch.service.DutchauctionService;
import com.stay.alive.auction.reverse.service.ReverseauctionService;

@Controller
public class MainController {
	@Autowired
	DutchauctionService dutchauctionService;
	@Autowired
	ReverseauctionService reverseauctionService;
	@GetMapping("/main")
	public String accessMain(Model model) {
		ArrayList<Map<String,Object>> recentDutchAuctionList = dutchauctionService.getRecentDutchAuctionList();
		model.addAttribute("recentDutchAuctionList", recentDutchAuctionList);
		model.addAttribute("recentReverseauctionList", reverseauctionService.getRecentReverseauctionList());
		return "main";
	}
	
	@GetMapping("/workingPage")
	public String accessWorkingPage() {
		return "workingPage";
	}
	
}
