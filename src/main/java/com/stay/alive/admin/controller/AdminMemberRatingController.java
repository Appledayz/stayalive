package com.stay.alive.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stay.alive.member.rating.service.MemberRatingService;
import com.stay.alive.member.rating.vo.MemberRating;

@Controller
@RequestMapping("admin")
public class AdminMemberRatingController {
	
	@Autowired
	private MemberRatingService memberRatingService;

	@GetMapping("memberRatingManagement")
	public String memberRatingManagement(Model model) {
		List<MemberRating> memberRatingList = memberRatingService.getMemberRatingList();
		model.addAttribute("memberRatingList", memberRatingList);
		return "admin/memberRatingManagement/memberRatingManagement";
	}
	
	@GetMapping("memberRatingRegister")	
	public String memberRatingRegister() {
		return "admin/memberRatingManagement/memberRatingRegister";
	}
	
	@PostMapping("memberRatingRegister")
	public String memberRatingRegister(MemberRating memberRating) {
		memberRatingService.memberRatingRegister(memberRating);
		return "redirect:/admin/memberRatingManagement";
	}
	
	@GetMapping("memberRatingModify")
	public String memberRatingModify(Model model, MemberRating memberRating, int ratingNo) {
		memberRating = memberRatingService.getMemberRating(ratingNo);
		model.addAttribute("ratingNo", memberRating.getRatingNo());
		model.addAttribute("ratingName", memberRating.getRatingName());
		return "admin/memberRatingManagement/memberRatingModify";
	}
	
	@PostMapping("memberRatingModify")
	public String memberRatingModify(MemberRating memberRating) {
		memberRatingService.memberRatingModify(memberRating);
		return "redirect:/admin/memberRatingManagement";
	}
	
	@GetMapping("memberRatingRemove")
	public String memberRatingRemove(int ratingNo) {
		memberRatingService.memberRatingRemove(ratingNo);
		return "redirect:/admin/memberRatingManagement";
	}
}
