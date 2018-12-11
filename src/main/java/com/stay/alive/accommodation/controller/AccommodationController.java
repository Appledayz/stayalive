package com.stay.alive.accommodation.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccommodationController {
	
	@GetMapping("accommodationRegister")
	public String accommodationRegister() {
		return "accommodation/accommodationRegister";
	}
	
	@RequestMapping(value="filesRequest", method = RequestMethod.POST)
	@ResponseBody
	public String filesRequest(HttpServletRequest request) {
		
		try {
			System.out.println(request.getHeader("file-name"));
			System.out.println(request.getHeader("file-size"));
			System.out.println(request.getHeader("file-Type"));
			InputStream inputStream = request.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

          

		return "asd";
	}
	
	
}
