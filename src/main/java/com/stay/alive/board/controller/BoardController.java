package com.stay.alive.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.board.service.BoardService;
import com.stay.alive.board.vo.BoardMember;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	//자유게시판
	@GetMapping("free")
	public String boardList(Model model) {
		ArrayList<BoardMember> boardMember = boardService.getBoardAll();
		model.addAttribute("list", boardMember);
		return "board/freeBoard";
	}
	//게시판 등록
	@GetMapping("register")
	public String boardRegister(HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			return "board/boardRegister";
		}
		else {
			model.addAttribute("msg","로그인 해주세요");
			model.addAttribute("url", "/board/free");
			return "alert";
		}
		
	}
	//게시판 등록 액션
	@PostMapping("register")
	public String boardRegisterAction(BoardMember boardMember,HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			String path = session.getServletContext().getRealPath("image/board");
			boardMember.setMemberId(memberId);
			boardService.addBoardMember(boardMember, path);
		}
		return "redirect:/board/free";
	}
	@GetMapping(value="findModify", produces="application/json")
	public @ResponseBody BoardMember boardFindModify(String name) {
		return boardService.getBoardInfo(name);
	}
	//게시판 수정
	@GetMapping("modify")
	public String boardModify(Model model) {
		String memberId = "id001";
		String[] names = boardService.getBoardName(memberId);
		model.addAttribute("names", names);
		return "board/boardModify";
	}
	//게시판 수정 액션
	@PostMapping("modifyAction")
	public String boardModifyAction(BoardMember boardMember, HttpSession session) {
		String memberId = "id001";
		String path = session.getServletContext().getRealPath("image/board");
		boardMember.setMemberId(memberId);
		boardService.modifyBoard(boardMember, path);
		return "redirect:/board/free";
	}
	//모달
	@GetMapping("detail")
	public @ResponseBody BoardMember boardDetail(int boardMemberNo) {
		return boardService.getBoardFromNo(boardMemberNo);
	}
	//게시글 삭제
	@GetMapping("remove")
	public String deleteBoard(int boardMemberNo) {
		return "redirect:/board/list";
	}
}
