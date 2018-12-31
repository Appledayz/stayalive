package com.stay.alive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String accessMain() {
		return "main";
	}
	
	@GetMapping("/auction")
	public String accessAuction() {
		return "auction";
	}
	
	@GetMapping("/workingPage")
	public String accessWorkingPage() {
		return "workingPage";
	}
	
}
