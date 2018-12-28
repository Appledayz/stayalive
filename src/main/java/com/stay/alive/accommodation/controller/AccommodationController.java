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
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.service.AccommodationService;
import com.stay.alive.accommodation.vo.Accommodation;
import com.stay.alive.company.service.CompanyService;
import com.stay.alive.company.vo.Company;
import com.stay.alive.member.service.MemberService;
import com.stay.alive.member.vo.Member;

@Controller
@RequestMapping("accommodation")
public class AccommodationController {
	@Autowired
	private AccommodationService accommodationService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CompanyService companyService;
	//숙소 메인
	@GetMapping("main")
	public String accommodation() {
		return "accommodation/accommodation";
	}
	//등록 뷰
	@GetMapping("register")
	public String accommodationRegister(Model model, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId == null) {
			return "redirect:/login";
		}
		Member member = memberService.getMember(memberId);
		int groupNo = member.getGroupNo();
		if(groupNo == 2 || groupNo == 4) {
			Company company = companyService.getCompanyFromId(memberId);
			model.addAttribute("companyNo", company.getCompanyNo());
			model.addAttribute("companyName", company.getCompanyName());
			
			return "accommodation/accommodationRegister";
		} else {
			return "redirect:/company/main";
		}
	}
	//등록 액션
	@PostMapping("register")
	public String  accommodationRegisterAction(Accommodation accommodation,HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		
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
		String[] names = accommodationService.getAccommodationNames(memberId);
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
	public @ResponseBody Accommodation accommodationDetail(int accommodationNo) {
		return accommodationService.getAccommodationFromNo(accommodationNo);
	}
	//숙소 리스트
	@GetMapping("list")
	public String accommodationList(Model model) {
		ArrayList<Accommodation> accommodation = accommodationService.getAccommodationAll();
		model.addAttribute("list", accommodation);
		return "accommodation/accommodationList";
	}
	//숙소 상세 이미지 등록(ajax요청)
	@PostMapping("addDetailImage")
	@ResponseBody
	public String addDetailImage(MultipartFile[] file,HttpSession session) {
		String path = session.getServletContext().getRealPath("image/accommodation");
		String memberId = "ID1";
		return accommodationService.addDetailImageFiles(file, path, memberId);
	}
}
