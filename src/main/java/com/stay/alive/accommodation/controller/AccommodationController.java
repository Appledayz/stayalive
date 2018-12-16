package com.stay.alive.accommodation.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.accommodation.service.AccommodationService;
import com.stay.alive.accommodation.vo.Accommodation;

@Controller
@RequestMapping("accommodation")
public class AccommodationController {
	@Autowired
	private AccommodationService accommodationService;
	@GetMapping("register")
	public String accommodationRegister() {
		return "accommodation/accommodationRegister";
	}
	@PostMapping("register")
	public String  accommodationRegisterAction(Accommodation accommodation,HttpSession session) {
		String memberId = "ID1";
		String path = session.getServletContext().getRealPath("image/business");
		accommodation.setMemberId(memberId);
		accommodationService.addAccommodation(accommodation, path);
		//System.out.println(accommodation);
		return "redirect:/main";
	}
	@GetMapping(value="findModify", produces="application/json")	
	public @ResponseBody Accommodation accommodationFindModify(String name) {
		return accommodationService.getAccommodationInfo(name);
	}
	@GetMapping("modify")
	public String  accommodationModify(Model model) {
		String memberId = "ID1"; //임시 아이디(세션추가 필요)
		String[] names = accommodationService.getAccommodationName(memberId);
		model.addAttribute("names", names);
		return "accommodation/accommodationModify";
	}

	@PostMapping("modifyAction")
	public String  accommodationModifyAction(Accommodation accommodation, HttpSession session) {
		String memberId = "ID1"; //임시 아이디(세션추가 필요)
		String path = session.getServletContext().getRealPath("image/business");
		accommodation.setMemberId(memberId);
		accommodationService.modifyAccommodation(accommodation, path);
		//System.out.println(accommodation);
		return "redirect:/main";
	}

	
}
