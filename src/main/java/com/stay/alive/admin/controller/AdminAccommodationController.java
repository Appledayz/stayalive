package com.stay.alive.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminAccommodationController {
	
	@GetMapping("accommodationManagement")
	public String accommodationManagement(Model model) {
		return "admin/accommodationManagement/accommodationManagement";
	}

}
