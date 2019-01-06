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

@Controller
@RequestMapping("auction/dutch")
public class DutchauctionController {
	@Autowired
	private DutchauctionService dutchauctionService;
	@GetMapping("list")
	public String dutchauctionList(Model model, 
								   @RequestParam(defaultValue = "1") int currentPage,
								   PageMaker pageMaker, 
								   @RequestParam(defaultValue = "") String searchKey, 
								   @RequestParam(defaultValue = "") String searchWord,
								   @RequestParam(defaultValue = "") String checkInDate,
								   @RequestParam(defaultValue = "") String checkOutDate)
	{
		pageMaker.setCurrentPage(currentPage);
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if((!searchKey.equals("") && !searchKey.equals("0")) || (!checkInDate.equals("") && !checkOutDate.equals(""))) {
			list = dutchauctionService.getDutchAuctionSearchList(pageMaker, searchKey, searchWord, checkInDate, checkOutDate);
		}
		else {
			list = dutchauctionService.getDutchAuctionList(pageMaker);
		}
		model.addAttribute("PM", pageMaker);
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("checkInDate", checkInDate);
		model.addAttribute("checkOutDate", checkOutDate);
		model.addAttribute("list",list);
		return "dutchauction/dutchauctionList";
	}
	//역경매 상세
	@GetMapping("detail")
	public String dutchauctionDetail(Model model, int dutchauctionNo, HttpSession session){
		Map<String, Object> detail = dutchauctionService.getDutchAuctionDetail(dutchauctionNo);
		String memberId = (String)session.getAttribute("memberId");
		if(memberId != null) {
			int groupNo = (int)session.getAttribute("groupNo");
			model.addAttribute("groupNo", groupNo);
			model.addAttribute("memberId", memberId);
		}
		model.addAttribute("detail", detail);
		return "dutchauction/dutchauctionDetail";
	}
	//역경매 삭제
	@GetMapping("delete")
	public String dutchauctionDelete(Model model, int dutchauctionNo, HttpSession session){
		String memberId = (String)session.getAttribute("memberId");
		int groupNo = (int)session.getAttribute("groupNo");
		DutchAuction dutchAuction = dutchauctionService.getDutchAuctionFromNo(dutchauctionNo);
		String hostId = dutchAuction.getMemberId();
		if(hostId.equals(memberId) && groupNo == 2 && dutchAuction.getAuctionStateCategoryNo() == 1) {
			int result = dutchauctionService.removeDutchAuction(dutchauctionNo);
			if(result == 0) {
				model.addAttribute("msg","삭제에 실패했습니다.");
				model.addAttribute("url","list");
				return "alert";
			}
		}
		else {
			model.addAttribute("msg","호스트가 아니거나 이미 낙찰된 경매입니다.");
			model.addAttribute("url","list");
			return "alert";
		}
		return "redirect:list";
	}
	//역경매 등록
	@GetMapping("register")
	public String dutchauctionRegister(Model model, HttpSession session) throws SchedulerException {
		String memberId = (String)session.getAttribute("memberId");
		if(memberId == null) {
			return "redirect:/login";
		}
		else {
			int groupNo = (int)session.getAttribute("groupNo");
			if(groupNo == 2 || groupNo == 3) {//회원이 호스트,관리자 일때 역경매 등록가능
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
		return "redirect:list";
	}
	@GetMapping("findGuestroomName")
	public @ResponseBody String[] findGuestroomName(String accommodationName) {
		return dutchauctionService.getGuestroomNamefromAccommodationName(accommodationName);
	}
	@GetMapping("guestroomInfo")
	public @ResponseBody GuestRoom guestroomInfo(String accommodationName,String guestroomName) {
		return dutchauctionService.getGuestroomInfo(accommodationName, guestroomName);
	}
	@GetMapping("closedlist")
	public @ResponseBody Map<String, Object> dutchauctionClosedList(int currentPage, PageMaker pageMaker) {
		Map<String, Object> map = new HashMap<String, Object>();
		pageMaker.setCurrentPage(currentPage);
		ArrayList<Map<String, Object>> closedList = dutchauctionService.getClosedDutchAuctionList(pageMaker);
		map.put("closedList", closedList);
		map.put("PM", pageMaker);
		return map;
	}
}
