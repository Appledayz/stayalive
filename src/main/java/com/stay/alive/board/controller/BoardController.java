package com.stay.alive.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.board.service.BoardService;
import com.stay.alive.board.vo.BoardMember;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	//게시판 메인
	@GetMapping("free")
	public String board() {
		return "board/freeBoard";
	}
	//게시판 등록
	@GetMapping("register")
	public String boardRegister() {
		return "board/boardRegister";
	}
	//게시판 등록 액션
	@PostMapping("register")
	public String boardRegisterAction(BoardMember boardMember,HttpSession session) {
		String memberId = "ID1";
		System.out.println(memberId+"-------------------------------------------------------------------------------");
		String path = session.getServletContext().getRealPath("image/board");
		boardMember.setMemberId(memberId);
		boardService.addBoardMember(boardMember, path);
		return "redirect:/board/free";
	}
	//게시판 수정
	@GetMapping("modify")
	public String boardModify(Model model) {
		String memberId = "ID1";
		String[] names = boardService.getBoardName(memberId);
		model.addAttribute("names", names);
		return "board/boardModify";
	}
}
