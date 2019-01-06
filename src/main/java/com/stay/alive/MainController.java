package com.stay.alive;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.auction.dutch.service.DutchauctionService;
import com.stay.alive.auction.reverse.service.ReverseauctionService;
import com.stay.alive.statistics.service.StatisticsService;
import com.stay.alive.statistics.vo.PieChartData;

@Controller
public class MainController {
	@Autowired
	DutchauctionService dutchauctionService;
	@Autowired
	ReverseauctionService reverseauctionService;
	@Autowired
	private StatisticsService statisticsService; 
	
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
	
	@GetMapping("flot")
	public String flotTest(Model model) {
		model.addAttribute("JsonArray", statisticsService.JsonArray());
		model.addAttribute("ArrayListString", statisticsService.ArrayListString());
		return "flot";
	}
	
	@GetMapping("memberCount")
	public @ResponseBody ArrayList<PieChartData> memberCount(){
		System.out.println("MainController.memberCount()");
		return statisticsService.getMemberCount();
	}
}
