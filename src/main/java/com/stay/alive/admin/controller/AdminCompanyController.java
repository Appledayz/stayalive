package com.stay.alive.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.company.service.CompanyService;
import com.stay.alive.company.vo.Company;

@Controller
@RequestMapping("admin")
public class AdminCompanyController {

	@Autowired 
	private CompanyService companyService;
	
	@GetMapping("companyManagement")
	public String companyManagement(Model model) {
		List<Company> companyList = companyService.getCompanyList();
		model.addAttribute("companyList", companyList);
		return "admin/companyManagement/companyManagement";
	}
}
