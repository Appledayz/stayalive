package com.stay.alive.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.company.service.CompanyService;
import com.stay.alive.company.vo.Company;
import com.stay.alive.member.service.MemberService;
import com.stay.alive.member.vo.Member;

@Controller
@RequestMapping("admin")
public class AdminCompanyController {

	@Autowired 
	private CompanyService companyService;
	@Autowired 
	private MemberService memberService;
	
	@GetMapping("companyManagement")
	public String companyManagement(Model model) {
		List<Company> companyList = companyService.getCompanyList();
		model.addAttribute("companyList", companyList);
		return "admin/companyManagement/companyManagement";
	}
	
	@GetMapping("companyRecognition")
	public String companyRecognition(Model model, int companyNo) {
		Company company = companyService.getCompanyFromNo(companyNo);
		Member member = memberService.getMember(company.getMemberId());
		int groupNo = member.getGroupNo();
		if(groupNo == 4) {
			model.addAttribute("msg", "숙소 승인 여부를 확인해주십시오.");
			model.addAttribute("url", "/admin/accommodationManagement");
			return "alert";
		} else {
			companyService.companyRecognitionModify(companyNo);
			return "redirect:/admin/companyManagement";	
		}
	}
}
