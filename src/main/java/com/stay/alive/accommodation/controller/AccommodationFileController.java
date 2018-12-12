package com.stay.alive.accommodation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.service.AccommodationService;


@Controller
public class AccommodationFileController {
	@Autowired
	private AccommodationService accommodationService;
	@PostMapping("filesRequest")
	@ResponseBody
	public String filesRequest(MultipartFile[] file,HttpSession session) {
		String realPath = session.getServletContext().getRealPath("image/accommodation");
		String  imageTag = accommodationService.addImageFiles(file, realPath);
		return imageTag;
	}
}
