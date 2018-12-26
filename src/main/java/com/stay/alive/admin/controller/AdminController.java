package com.stay.alive.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.member.group.service.MemberGroupService;
import com.stay.alive.member.group.vo.MemberGroup;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private MemberGroupService memberGroupService;
	
	@GetMapping("main")
	public String admin() {
		return "admin/admin";
	}
	
	@GetMapping("memberGroupManagement")
	public String memberGroupManagement(Model model) {
		List<MemberGroup> memberGroupList = memberGroupService.getMemberGroupList();
		model.addAttribute("memberGroupList", memberGroupList);
		return "admin/memberGroupManagement";
	}
}
