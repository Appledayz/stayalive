package com.stay.alive.accommodation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.accommodation.vo.Accommodation;

@Controller
public class AccommodationController {
	@GetMapping("accommodationRegister")
	public String accommodationRegister() {
		return "accommodation/accommodationRegister";
	}
	@PostMapping("accommodationRegister")
	public String  accommodationRegisterAction(Accommodation accommodation) {
		System.out.println(accommodation);
		return "redirect:/main";
	}
	
}
