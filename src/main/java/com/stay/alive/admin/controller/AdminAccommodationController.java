package com.stay.alive.admin.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.accommodation.service.AccommodationService;
import com.stay.alive.accommodation.vo.Accommodation;

@Controller
@RequestMapping("admin")
public class AdminAccommodationController {
	
	@Autowired 
	private AccommodationService accommodationService;
	
	@GetMapping("accommodationManagement")
	public String accommodationManagement(Model model) {
		ArrayList<Accommodation> accommodationList = accommodationService.getAccommodationList();
		model.addAttribute("accommodationList", accommodationList);
		return "admin/accommodationManagement/accommodationManagement";
	}
	
	@GetMapping("accommodationRecognition")
	public String accommodationRecognition(int accommodationNo, HttpServletResponse response) {
		accommodationService.accommodationRecognitionModify(accommodationNo);
		return "redirect:/admin/accommodationManagement";
	}

}
