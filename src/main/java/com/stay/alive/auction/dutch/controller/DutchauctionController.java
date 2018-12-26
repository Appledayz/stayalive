package com.stay.alive.auction.dutch.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.auction.dutch.service.DutchauctionService;
import com.stay.alive.auction.dutch.vo.DutchAuction;
import com.stay.alive.guestroom.vo.GuestRoom;

@Controller
@RequestMapping("auction/dutch")
public class DutchauctionController {
	private int groupNum = 0;
	@Autowired
	private DutchauctionService dutchauctionService;

	@GetMapping("register")
	public String dutchauctionRegister(Model model) throws SchedulerException {
		String id = "ID1";
		String[] accommodationName = dutchauctionService.getAccommodationName(id);
		model.addAttribute("name", accommodationName);
		return "dutchauction/dutchauctionRegister";
	}
	//역경매 등록
	@PostMapping("registerAction")
	public @ResponseBody String registerActionDutch(String accommodationName,
													String guestroomName,
													MultipartFile guestroomImageFile,
													int guestroomSize,
													int guestroomCapacity,
													String guestroomDetail,
													int dutchauctionStartprice,
													int dutchauctionSaleUnit,
													int dutchauctionSaleInterval,
													String dutchauctionCloseDate,
													String dutchauctionCheckinDate,
													String dutchauctionCheckoutDate,
													int guestroomAddOrSelect,
													HttpSession session) 
	{
		String memberId = "ID1";
		DutchAuction dutchAuction = new DutchAuction();
		dutchAuction.setMemberId(memberId);
		dutchAuction.setAccommodationName(accommodationName);
		dutchAuction.setGuestroomName(guestroomName);
		dutchAuction.setDutchauctionStartprice(dutchauctionStartprice);
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
		return "registerAction";
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
