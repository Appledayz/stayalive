package com.stay.alive.accommodation.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.service.AccommodationService;
import com.stay.alive.accommodation.vo.Accommodation;
import com.stay.alive.common.PageMaker;
import com.stay.alive.company.service.CompanyService;
import com.stay.alive.company.vo.Company;

@Controller
@RequestMapping("accommodation")
public class AccommodationController {
	@Autowired
	private AccommodationService accommodationService;
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
		String groupName = (String)session.getAttribute("groupName");
		if(memberId == null) {
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/login");
			return "alert";
		}
		if(!groupName.equals("게스트")) {
			Company company = companyService.getCompanyFromId(memberId);
			model.addAttribute("companyNo", company.getCompanyNo());
			model.addAttribute("companyName", company.getCompanyName());
			return "accommodation/accommodationRegister";
		} else {
			model.addAttribute("msg", "업체를 등록하셔야 숙소등록이 가능합니다.");
			model.addAttribute("url", "/company/main");
			return "alert";
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
	public String  accommodationModify(Model model, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		String groupName = (String)session.getAttribute("groupName");
		
		if(memberId == null) {
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/login");
			return "alert";
		}
		else if(!groupName.equals("게스트")) {
			String[] names = accommodationService.getAccommodationNames(memberId);
			model.addAttribute("names", names);
			return "accommodation/accommodationModify";
		}
		else {
			model.addAttribute("msg", "게스트는 숙소수정이 불가능합니다.");
			model.addAttribute("url", "/main");
			return "alert";
		}
	}
	//수정 액션
	@PostMapping("modifyAction")
	public String  accommodationModifyAction(Accommodation accommodation, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		String path = session.getServletContext().getRealPath("image/business");
		accommodation.setMemberId(memberId);
		accommodationService.modifyAccommodation(accommodation, path);
		return "redirect:/main";
	}
	//모달을 사용하는 상세정보 
	@GetMapping("detail")
	public @ResponseBody Accommodation accommodationDetail(int accommodationNo) {
		return accommodationService.getAccommodationFromNo(accommodationNo);
	}
	//숙소 리스트
	@GetMapping("list")
	public String accommodationList(Model model, 
									@RequestParam(defaultValue="1") int currentPage, 
									PageMaker pageMaker, 
									@RequestParam(defaultValue="") String searchKey, 
									@RequestParam(defaultValue="") String searchWord) 
	{
		pageMaker.setCurrentPage(currentPage);
		ArrayList<Accommodation> accommodationList = new ArrayList<Accommodation>();
		if(!searchKey.equals("") && !searchKey.equals("0")) {
			accommodationList = accommodationService.getAccommodationSearchList(pageMaker, searchKey, searchWord);
		}
		else {
			accommodationList = accommodationService.getAccommodationList(pageMaker);
		}
		model.addAttribute("PM", pageMaker);
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("list", accommodationList);
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
