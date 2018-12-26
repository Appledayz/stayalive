package com.stay.alive.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		return "admin/memberGroupManagement/memberGroupManagement";
	}
	
	@GetMapping("memberGroupRegister")	
	public String memberGroupRegister() {
		return "admin/memberGroupManagement/memberGroupRegister";
	}
	
	@PostMapping("memberGroupRegister")
	public String memberGroupRegister(MemberGroup memberGroup) {
		memberGroupService.memberGroupRegister(memberGroup);
		return "redirect:/admin/memberGroupManagement";
	}
	
	@GetMapping("memberGroupModify")
	public String memberGroupModify(Model model, MemberGroup memberGroup, int groupNo) {
		memberGroup = memberGroupService.getMemberGroup(groupNo);
		model.addAttribute("groupNo", memberGroup.getGroupNo());
		model.addAttribute("groupName", memberGroup.getGroupName());
		return "admin/memberGroupManagement/memberGroupModify";
	}
	
	@PostMapping("memberGroupModify")
	public String memberGroupModify(MemberGroup memberGroup) {
		memberGroupService.memberGroupModify(memberGroup);
		return "redirect:/admin/memberGroupManagement";
	}
	
	@GetMapping("memberGroupRemove")
	public String memberGroupRemove(int groupNo) {
		memberGroupService.memberGroupRemove(groupNo);
		return "redirect:/admin/memberGroupManagement";
	}
	
	
}
