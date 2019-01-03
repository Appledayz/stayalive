package com.stay.alive.auction.dutch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.auction.dutch.service.DutchauctionService;
import com.stay.alive.auction.dutch.vo.DutchAuction;
import com.stay.alive.common.PageMaker;
import com.stay.alive.guestroom.vo.GuestRoom;
import com.stay.alive.member.service.MemberService;

@Controller
@RequestMapping("auction/dutch")
public class DutchauctionController {
	@Autowired
	private DutchauctionService dutchauctionService;
	@Autowired
	private MemberService memberService;
	@GetMapping("list")
	public String dutchauctionList(Model model, 
								   @RequestParam(defaultValue = "1") int currentPage, 
								   HashMap<String, String> paraMap, 
								   PageMaker pageMaker, 
								   @RequestParam(defaultValue = "") String sk, 
								   @RequestParam(defaultValue = "") String sv,
								   @RequestParam(defaultValue = "") String checkInDate,
								   @RequestParam(defaultValue = "") String checkOutDate)
	{
		pageMaker.setCurrentPage(currentPage);
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if((!sk.equals("") && !sk.equals("0")) || (!checkInDate.equals("") && !checkOutDate.equals(""))) {
			list = dutchauctionService.getDutchAuctionSearchList(pageMaker, sk, sv, checkInDate, checkOutDate);
		}
		else {
			list = dutchauctionService.getDutchAuctionList(pageMaker);
		}
		
		ArrayList<Map<String, Object>> closedList = dutchauctionService.getClosedDutchAuctionList();
		model.addAttribute("PM", pageMaker);
		model.addAttribute("sk", sk);
		model.addAttribute("sv", sv);
		model.addAttribute("checkInDate", checkInDate);
		model.addAttribute("checkOutDate", checkOutDate);
		model.addAttribute("list",list);
		model.addAttribute("closedList",closedList);
		return "dutchauction/dutchauctionList";
	}
	//역경매 상세
	@GetMapping("detail")
	public String dutchauctionDetail(Model model, int dutchauctionNo){
		Map<String, Object> detail = dutchauctionService.getDutchAuctionDetail(dutchauctionNo);
		model.addAttribute("detail", detail);
		return "dutchauction/dutchauctionDetail";
	}
	//역경매 등록
	@GetMapping("register")
	public String dutchauctionRegister(Model model, HttpSession session) throws SchedulerException {
		String memberId = (String)session.getAttribute("memberId");
		String groupName = (String)session.getAttribute("groupName");
		if(memberId == null) {
			return "redirect:/login";
		}
		else if(memberId != null && (groupName.equals("호스트") || groupName.equals("관리자"))) {//회원이 호스트,관리자 일때 역경매 등록가능
			String[] accommodationName = dutchauctionService.getAccommodationName(memberId);
			model.addAttribute("name", accommodationName);
			return "dutchauction/dutchauctionRegister";
		}
		else {
			model.addAttribute("msg","호스트만 경매 등록이 가능합니다.");
			model.addAttribute("url","/main");
			return "alert";
		}
	}
	//역경매 등록액션
	@PostMapping("registerAction")
	public String registerActionDutch(String accommodationName,
													String guestroomName,
													MultipartFile guestroomImageFile,
													int guestroomSize,
													int guestroomCapacity,
													String guestroomDetail,
													int dutchauctionStartprice,
													int maximumDiscountPrice,
													int dutchauctionSaleUnit,
													int dutchauctionSaleInterval,
													String dutchauctionCloseDate,
													String dutchauctionCheckinDate,
													String dutchauctionCheckoutDate,
													int guestroomAddOrSelect,
													HttpSession session) 
	{
		String memberId = (String)session.getAttribute("memberId");
		DutchAuction dutchAuction = new DutchAuction();
		dutchAuction.setMemberId(memberId);
		dutchAuction.setAccommodationName(accommodationName);
		dutchAuction.setGuestroomName(guestroomName);
		dutchAuction.setDutchauctionStartprice(dutchauctionStartprice);
		dutchAuction.setDutchauctionUpdatePrice(dutchauctionStartprice);
		dutchAuction.setMaximumDiscountPrice(maximumDiscountPrice);
		dutchAuction.setDutchauctionSaleUnit(dutchauctionSaleUnit);
		dutchAuction.setDutchauctionSaleInterval(dutchauctionSaleInterval);
		dutchAuction.setDutchauctionCloseDate(dutchauctionCloseDate);
		dutchAuction.setDutchauctionCheckinDate(dutchauctionCheckinDate);
		dutchAuction.setDutchauctionCheckoutDate(dutchauctionCheckoutDate);
		if(guestroomAddOrSelect == 0) { //객실과 역경매 등록
			GuestRoom guestRoom = new GuestRoom();
			guestRoom.setMemberId(memberId);
			guestRoom.setAccommodationName(accommodationName);
			guestRoom.setGuestroomName(guestroomName);
			guestRoom.setGuestroomSize(guestroomSize);
			guestRoom.setGuestroomCapacity(guestroomCapacity);
			guestRoom.setGuestroomDetail(guestroomDetail);
			String path = session.getServletContext().getRealPath("image/guestroom"); //객실 이미지 파일 저장될 경로
			dutchauctionService.addDutchAuctionAndGuestroom(guestRoom, dutchAuction, guestroomImageFile, path, memberId, accommodationName);
		}
		else { //기존의 객실로 역경매 등록
			dutchauctionService.addDutchAuction(dutchAuction, memberId, accommodationName);
		}
		return "redirect:/main";
	}
	@GetMapping("findGuestroomName")
	public @ResponseBody String[] findGuestroomName(String accommodationName) {
		return dutchauctionService.getGuestroomNamefromAccommodationName(accommodationName);
	}
	@GetMapping("guestroomInfo")
	public @ResponseBody GuestRoom guestroomInfo(String accommodationName,String guestroomName) {
		return dutchauctionService.getGuestroomInfo(accommodationName, guestroomName);
	}
}
