package com.stay.alive.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.member.state.service.MemberStateService;
import com.stay.alive.member.state.vo.MemberState;

@Controller
@RequestMapping("admin")
public class AdminMemberStateController {
	
	@Autowired
	private MemberStateService memberStateService;

	@GetMapping("memberStateManagement")
	public String memberStateManagement(Model model) {
		List<MemberState> memberStateList = memberStateService.getMemberStateList();
		model.addAttribute("memberStateList", memberStateList);
		return "admin/memberStateManagement/memberStateManagement";
	}
	
	@GetMapping("memberStateRegister")	
	public String memberStateRegister() {
		return "admin/memberStateManagement/memberStateRegister";
	}
	
	@PostMapping("memberStateRegister")
	public String memberStateRegister(MemberState memberState) {
		memberStateService.memberStateRegister(memberState);
		return "redirect:/admin/memberStateManagement";
	}
	
	@GetMapping("memberStateModify")
	public String memberStateModify(Model model, MemberState memberState, int stateNo) {
		memberState = memberStateService.getMemberState(stateNo);
		model.addAttribute("stateNo", memberState.getStateNo());
		model.addAttribute("stateName", memberState.getStateName());
		return "admin/memberStateManagement/memberStateModify";
	}
	
	@PostMapping("memberStateModify")
	public String memberStateModify(MemberState memberState) {
		memberStateService.memberStateModify(memberState);
		return "redirect:/admin/memberStateManagement";
	}
	
	@GetMapping("memberStateRemove")
	public String memberStateRemove(int stateNo) {
		memberStateService.memberStateRemove(stateNo);
		return "redirect:/admin/memberStateManagement";
	}
}
