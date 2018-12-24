package com.stay.alive.accommodation.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.accommodation.service.AccommodationService;
import com.stay.alive.accommodation.vo.Accommodation;

@Controller
@RequestMapping("accommodation")
public class AccommodationController {
	@Autowired
	private AccommodationService accommodationService;
	//숙소 메인
	@GetMapping("main")
	public String accommodation() {
		return "accommodation/accommodation";
	}
	//등록 뷰
	@GetMapping("register")
	public String accommodationRegister() {
		return "accommodation/accommodationRegister";
	}
	//등록 액션
	@PostMapping("register")
	public String  accommodationRegisterAction(Accommodation accommodation,HttpSession session) {
		String memberId = "ID1";
		String path = session.getServletContext().getRealPath("image/business");
		accommodation.setMemberId(memberId);
		accommodationService.addAccommodation(accommodation, path);
		//System.out.println(accommodation);
		return "redirect:/main";
	}
	@GetMapping(value="findModify", produces="application/json")	
	public @ResponseBody Accommodation accommodationFindModify(String name) {
		return accommodationService.getAccommodationInfo(name);
	}
	//수정 뷰
	@GetMapping("modify")
	public String  accommodationModify(Model model) {
		String memberId = "ID1"; //임시 아이디(세션추가 필요)
		String[] names = accommodationService.getAccommodationName(memberId);
		model.addAttribute("names", names);
		return "accommodation/accommodationModify";
	}
	//수정 액션
	@PostMapping("modifyAction")
	public String  accommodationModifyAction(Accommodation accommodation, HttpSession session) {
		String memberId = "ID1"; //임시 아이디(세션추가 필요)
		String path = session.getServletContext().getRealPath("image/business");
		accommodation.setMemberId(memberId);
		accommodationService.modifyAccommodation(accommodation, path);
		//System.out.println(accommodation);
		return "redirect:/main";
	}
	//모달을 사용하는 상세정보 
	@GetMapping("detail")
	public @ResponseBody Accommodation accommodationDetail(int accommodationNo, Model model) {
		return accommodationService.getAccommodationFromNo(accommodationNo);
	}
	//숙소 리스트
	@GetMapping("list")
	public String accommodationList(Model model) {
		ArrayList<Accommodation> accommodation = accommodationService.getAccommodationAll();
		model.addAttribute("list", accommodation);
		return "accommodation/accommodationList";
	}
}
