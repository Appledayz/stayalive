package com.stay.alive.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardFileController {
	@Autowired
	private BoardService boardService;
	
	@PostMapping("addDetailImage")
	@ResponseBody
	public String addDetailImage(MultipartFile[] file,HttpSession session) {
		String path = session.getServletContext().getRealPath("image/board");
		String memberId = "ID1";
		return boardService.addDetailImageFiles(file, path, memberId);
	}
}
