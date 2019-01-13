package com.stay.alive.payment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	
	@GetMapping("main")
	public String payment() {
		return "payment/payment";
	}
	
	@PostMapping("payment")
	public String paymentSuccess() {
		return "redirect:/main";
	}
}
