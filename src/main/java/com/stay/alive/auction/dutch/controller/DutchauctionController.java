package com.stay.alive.auction.dutch.controller;

import static org.quartz.DateBuilder.dateOf;

import javax.servlet.http.HttpSession;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.auction.dutch.service.DutchAuctionRegisterJob;
import com.stay.alive.auction.dutch.service.DutchauctionService;
import com.stay.alive.auction.dutch.vo.DutchAuction;
import com.stay.alive.company.vo.Company;
import com.stay.alive.file.ImageFile;
import com.stay.alive.file.mapper.ImageFileMapper;
import com.stay.alive.guestroom.vo.GuestRoom;

@Controller
@RequestMapping("auction/dutch")
public class DutchauctionController {
	private int groupNum = 0;
	@Autowired
	private DutchauctionService dutchauctionService;

	@GetMapping("register")
	public String dutchauctionRegister(Model model) throws SchedulerException {
		
		/*
		 * Scheduler sched = schedulerFactoryBean.getScheduler(); JobDetail jobDetail =
		 * sampleJobDetail(); Trigger trigger = sampleJobTrigger();
		 * sched.scheduleJob(jobDetail, trigger); groupNum++; sched.start();
		 */
		String id = "ID1";
		String[] accommodationName = dutchauctionService.getAccommodationName(id);
		model.addAttribute("name", accommodationName);
		return "dutchauction/dutchauctionRegister";
	}
	@PostMapping("register")
	public String dutchauctionRegisterAction() {
		/*		Scheduler sched = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail = jobDetail();
		Trigger trigger = jobTrigger();
		sched.scheduleJob(jobDetail, trigger);
		groupNum++;
		sched.start();
		Calendar cal = Calendar.getInstance();
		String dateStr = "2018-10-17 09:03:56";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		cal.setTime(dt.parse(dateStr));
		System.out.println(cal.getTime());0
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		*/
		
		return "dutchauction/dutchauctionRegister";
	}	

	//역경매 등록
	@PostMapping("registerAction")
	public @ResponseBody String registerActionDutch(
			String accommodationName,
			String guestroomName,
			MultipartFile guestroomImageFile,
			int guestroomSize,
			int guestroomCapacity,
			String guestroomDetail,
			int dutchauctionSaleUnit,
			int dutchauctionSaleInterval,
			String dutchauctionCloseDate,
			String dutchauctionCheckindate,
			String dutchauctionCheckoutDate,
			int guestroomAddOrSelect,
			HttpSession session) {
		String memberId = "ID1";
		
		if(guestroomAddOrSelect == 0) { //객실과 역경매 등록
			GuestRoom guestRoom = new GuestRoom();
			DutchAuction dutchAuction = new DutchAuction();

			guestRoom.setMemberId(memberId);
			guestRoom.setAccommodationName(accommodationName);
			guestRoom.setGuestroomName(guestroomName);
			guestRoom.setGuestroomSize(guestroomSize);
			guestRoom.setGuestroomCapacity(guestroomCapacity);
			guestRoom.setGuestroomDetail(guestroomDetail);
			
			String path = session.getServletContext().getRealPath("image/guestroom"); //객실 이미지 파일 저장될 경로
			
			dutchauctionService.addDutchAuctionAndGuestroom(guestRoom, dutchAuction, guestroomImageFile, path, memberId, accommodationName);
			
			//아래에는 객실추가, 역경매 추가 필요
		}
		else { //기존의 객실로 역경매 등록
			System.out.println(accommodationName);
			System.out.println(guestroomAddOrSelect);
			System.out.println(guestroomImageFile);
			System.out.println(dutchauctionCheckoutDate + "<== 체크인 날");
			
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
