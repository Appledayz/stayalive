package com.stay.alive;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.stay.alive.auction.dutch.service.DutchauctionService;

@Controller
public class MainController {
	@Autowired
	DutchauctionService dutchauctionService;
	@GetMapping("/main")
	public String accessMain(Model model) {
		ArrayList<Map<String,Object>> recentDutchAuctionList = dutchauctionService.getRecentDutchAuctionList();
		
		model.addAttribute("recentDutchAuctionList", recentDutchAuctionList);
		return "main";
	}
	
	@GetMapping("/workingPage")
	public String accessWorkingPage() {
		return "workingPage";
	}
	
}
