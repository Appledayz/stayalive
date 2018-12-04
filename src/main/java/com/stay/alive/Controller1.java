package com.stay.alive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {
	@Autowired
	Mapper1 mapper;
	@GetMapping("hello")
	public String hello(Model model) {
		
		model.addAttribute("hello", mapper.a());
		return "index";
	}
}
