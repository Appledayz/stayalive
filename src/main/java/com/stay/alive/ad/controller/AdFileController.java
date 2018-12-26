package com.stay.alive.ad.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.ad.service.AdService;

@Controller
@RequestMapping("/ad")
public class AdFileController {
	@Autowired
	private AdService adService;
	@PostMapping("addAdFile")
	@ResponseBody
	public int addAdFile(MultipartFile file,HttpSession session) {
		String path = session.getServletContext().getRealPath("image/ad");
		String memberId = "ID1";
		return adService.addAdFiles(file, path, memberId);
	}
}
