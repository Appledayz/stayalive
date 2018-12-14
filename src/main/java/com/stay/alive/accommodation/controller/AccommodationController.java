package com.stay.alive.accommodation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.accommodation.service.AccommodationService;
import com.stay.alive.accommodation.vo.Accommodation;

@Controller
public class AccommodationController {
	@Autowired
	private AccommodationService accommodationService;
	@GetMapping("accommodationRegister")
	public String accommodationRegister() {
		return "accommodation/accommodationRegister";
	}
	@PostMapping("accommodationRegister")
	public String  accommodationRegisterAction(Accommodation accommodation,HttpSession session) {
		String memberId = "ID1";
		String path = session.getServletContext().getRealPath("image/business");
		accommodation.setMemberId(memberId);
		accommodationService.addAccommodation(accommodation, path);
		//System.out.println(accommodation);
		return "redirect:/main";
	}
	@GetMapping("accommodationModify")
	public String  accommodationModify() {

		return "accommodation/accommodationModify";
	}
	
	@PostMapping("accommodationModifyAction")
	public String  accommodationModifyAction(Accommodation accommodation,HttpSession session) {
		String memberId = "ID1";
		String path = session.getServletContext().getRealPath("image/business");
		accommodation.setMemberId(memberId);
		accommodationService.addAccommodation(accommodation, path);
		//System.out.println(accommodation);
		return "redirect:/main";
	}
	@GetMapping("test")
	@ResponseBody
	public String test() {
		accommodationService.test();
		return "call";
	}
	
}
