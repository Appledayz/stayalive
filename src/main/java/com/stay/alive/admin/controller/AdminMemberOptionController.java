package com.stay.alive.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.member.option.service.MemberOptionService;
import com.stay.alive.member.option.vo.MemberOption;

@Controller
@RequestMapping("admin")
public class AdminMemberOptionController {
	
	@Autowired
	private MemberOptionService memberOptionService;

	@GetMapping("memberOptionManagement")
	public String memberOptionManagement(Model model) {
		List<MemberOption> memberOptionList = memberOptionService.getMemberOptionList();
		model.addAttribute("memberOptionList", memberOptionList);
		return "admin/memberOptionManagement/memberOptionManagement";
	}
	
	@GetMapping("memberOptionRegister")	
	public String memberOptionRegister() {
		return "admin/memberOptionManagement/memberOptionRegister";
	}
	
	@PostMapping("memberOptionRegister")
	public String memberOptionRegister(MemberOption memberOption) {
		memberOptionService.memberOptionRegister(memberOption);
		return "redirect:/admin/memberOptionManagement";
	}
	
	@GetMapping("memberOptionModify")
	public String memberOptionModify(Model model, MemberOption memberOption, int memberOptionNo) {
		memberOption = memberOptionService.getMemberOption(memberOptionNo);
		model.addAttribute("memberOptionNo", memberOption.getMemberOptionNo());
		model.addAttribute("memberOptionName", memberOption.getMemberOptionName());
		model.addAttribute("memberOptionDetail", memberOption.getMemberOptionDetail());
		return "admin/memberOptionManagement/memberOptionModify";
	}
	
	@PostMapping("memberOptionModify")
	public String memberOptionModify(MemberOption memberOption) {
		memberOptionService.memberOptionModify(memberOption);
		return "redirect:/admin/memberOptionManagement";
	}
	
	@GetMapping("memberOptionRemove")
	public String memberOptionRemove(int memberOptionNo) {
		memberOptionService.memberOptionRemove(memberOptionNo);
		return "redirect:/admin/memberOptionManagement";
	}
}
