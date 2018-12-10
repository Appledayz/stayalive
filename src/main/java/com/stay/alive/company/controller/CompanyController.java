package com.stay.alive.company.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.stay.alive.company.service.CompanyService;
import com.stay.alive.company.vo.Company;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@GetMapping("company")
	public String company() {
		return "/company/company";
	}
	@GetMapping("companyRegister")
	public String companyRegister() {
		return "/company/companyRegister";
	}
	@PostMapping("companyRegister")
	public String companyRegister(Company company,HttpSession session) {
		String contextPath = session.getServletContext().getRealPath("/upload/images");
		companyService.companyRegister(company, contextPath);
		return "redirect:/";
	}
}
