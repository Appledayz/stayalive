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
	@PostMapping("addDetailImage")
	@ResponseBody
	public String addDetailImage(MultipartFile[] file,HttpSession session) {
		String path = session.getServletContext().getRealPath("image/accommodation");
		String memberId = "ID1";
		return accommodationService.addDetailImageFiles(file, path, memberId);
	}
}
