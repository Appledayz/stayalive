package com.stay.alive.auction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuctionController {

	@GetMapping("auction")
	public String auction() {
		return "auction/auction";
	}
	
	@GetMapping("myAuctionList")
	public String myAuctionList() {
		return "auction/myAuctionList";
	}
	
}
