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
	
	//글 이미지 등록
	@PostMapping("addDetailImage")
	@ResponseBody
	public String addDetailImage(MultipartFile[] file,HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			String path = session.getServletContext().getRealPath("image/board");
			return boardService.addDetailImageFiles(file, path, memberId);
		}
		else {
			return "";
		}
	}
}
