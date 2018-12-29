package com.stay.alive.company.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stay.alive.common.PageMaker;
import com.stay.alive.company.service.CompanyService;
import com.stay.alive.company.vo.Company;
import com.stay.alive.member.service.MemberService;
import com.stay.alive.member.vo.Member;

@Controller
@RequestMapping("company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private MemberService memberService;
	
	@GetMapping("main")
	public String company() {
		return "company/company";
	}
	
	@GetMapping("register")
	public String companyRegister(Model model, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		int companyRegisterCheckNo = companyService.checkMemberIdOfCompany(memberId);
		if(memberId == null) {
			model.addAttribute("msg", "로그인이 필요합니다.");
			model.addAttribute("url", "/login");
			return "alert";
		} else if(companyRegisterCheckNo == 1) {
			model.addAttribute("msg", "이미 업체를 등록하셨습니다. 숙소를 등록해 주세요.");
			model.addAttribute("url", "/accommodation/main");
			return "alert";
		} else {
			model.addAttribute("memberId", memberId);
			return "company/companyRegister";
		}
	}
	
	@PostMapping("register")
	public String companyRegister(Company company, HttpSession session) {
		String contextPath = session.getServletContext().getRealPath("/upload/images");
		companyService.companyRegister(company, contextPath);
		System.out.println(company.getMemberId() + "<--memberId");
		Member member = memberService.getMember(company.getMemberId());
		session.setAttribute("groupName", member.getGroupName());
		System.out.println(member.getGroupName() + "<--groupName");
		return "redirect:/accommodation/main";
	}
	
	@GetMapping("list")
	public String companyList(Model model, PageMaker pageMaker, HashMap<String, Object> map, 
							@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
							@RequestParam(value = "searchKey", defaultValue = "") String searchKey,
							@RequestParam(value = "searchWord", defaultValue = "") String searchWord) {
		pageMaker.setCurrentPage(currentPage);
		map.put("pageMaker", pageMaker);
		map.put("searchKey", searchKey);
		map.put("searchWord", "%"+searchWord+"%");
		List<HashMap<String, Object>> memberAndCompanyList = companyService.getCompanySearchList(map);
		model.addAttribute("memberAndCompanyList", memberAndCompanyList);
		model.addAttribute("companyListCount", (int)map.get("companyListCount"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pagePerBlock", pageMaker.getPagePerBlock());
		model.addAttribute("currentBlock", pageMaker.getCurrentBlock());
		model.addAttribute("startPage", pageMaker.getStartPage());
		model.addAttribute("endPage", pageMaker.getEndPage());
		model.addAttribute("prevPage", pageMaker.isPrevPage());
		model.addAttribute("nextPage", pageMaker.isNextPage());
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("searchWord", searchWord);
		return "company/companyList";
	}
	
	@GetMapping("detail")
	public @ResponseBody Company companyDetail(int companyNo, Model model) {
	return companyService.getCompanyFromNo(companyNo);
	}
	
}
