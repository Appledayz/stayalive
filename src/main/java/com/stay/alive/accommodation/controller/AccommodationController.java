package com.stay.alive.accommodation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccommodationController {
	
	@GetMapping("accommodationRegister")
	public String accommodationRegister() {
		return "accommodation/accommodationRegister";
	}
	
	@RequestMapping(value="filesRequest", method = RequestMethod.POST)
	@ResponseBody
	public String filesRequest(MultipartFile[] file) {
		System.out.println(file[0].getOriginalFilename());
		System.out.println(file[1].getOriginalFilename());
		return "<img src=/resource/02map-7.gif><br>";
	}
	@RequestMapping(value="registerAction", method = RequestMethod.POST)
	@ResponseBody
	public String registerAction(String name1,String editor) {
		System.out.println(name1);
		System.out.println(editor);
		return "hello world";
	}
	
}
