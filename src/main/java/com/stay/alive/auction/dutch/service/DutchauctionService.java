package com.stay.alive.auction.dutch.service;

import static org.quartz.DateBuilder.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.mapper.AccommodationMapper;
import com.stay.alive.auction.dutch.mapper.DutchauctionMapper;
import com.stay.alive.auction.dutch.vo.DutchAuction;
import com.stay.alive.company.mapper.CompanyMapper;
import com.stay.alive.company.vo.Company;
import com.stay.alive.file.ImageFile;
import com.stay.alive.file.mapper.ImageFileMapper;
import com.stay.alive.guestroom.mapper.GuestRoomMapper;
import com.stay.alive.guestroom.vo.GuestRoom;

@Service
@Transactional
public class DutchauctionService {
	@Autowired
	private ImageFileMapper imageFileMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private AccommodationMapper accommodationMapper;
	@Autowired 
	private DutchauctionMapper dutchauctionMapper;
	@Autowired
	private GuestRoomMapper guestRoomMapper;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	public JobDetail jobDetail(DutchAuction dutchAuction) {
		JobDataMap jabDataMap = new JobDataMap();
		jabDataMap.put("dutchAuction", dutchAuction);
		jabDataMap.put("dutchauctionMapper", dutchauctionMapper);
		return JobBuilder.newJob(DutchAuctionRegisterJob.class).withIdentity("JOB"+ dutchAuction.getDutchauctionNo())
				.usingJobData(jabDataMap).storeDurably().build();
	}
	public Trigger jobTrigger(DutchAuction dutchAuction) {
		Calendar calendar = Calendar.getInstance();
		String dateTimeStr = dutchAuction.getDutchauctionCloseDate();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			calendar.setTime(simpleDateFormat.parse(dateTimeStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(10).repeatForever(); //.withIntervalInHours(dutchAuction.getDutchauctionSaleInterval()).repeatForever();
		return TriggerBuilder.newTrigger().forJob(jobDetail(dutchAuction))
				.withIdentity("TRIGGER"+dutchAuction.getDutchauctionNo()).startAt(futureDate(10, IntervalUnit.SECOND)).endAt(dateOf(hour, minute, second, day, month , year)).withSchedule(scheduleBuilder).build();
	}
	public void addDutchAuctionScheduler(DutchAuction dutchAuction) {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobDetail jobDetail = jobDetail(dutchAuction);
		Trigger trigger = jobTrigger(dutchAuction);
		try {
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String[] getAccommodationName(String memberId) {
		return accommodationMapper.selectAccommodationName(memberId);
	}
	public String[] getGuestroomNamefromAccommodationName(String accommodationName) {
		return guestRoomMapper.selectGuestroomNames(accommodationName);
	}
	public GuestRoom getGuestroomInfo(String accommodationName, String guestroomName) {
		return guestRoomMapper.selectGuestroomInfo(accommodationName, guestroomName);
	}
	//네덜란드식 역경매 등록
	public void addDutchAuction(DutchAuction dutchAuction, String memberId, String accommodationName) {
		int accommodationNo = accommodationMapper.selectAccommodationNo(accommodationName); //숙소 번호
		dutchAuction.setAccommodationNo(accommodationNo);
		Company company = companyMapper.selectCompanyFromId(memberId);
		dutchAuction.setCompanyNo(company.getCompanyNo());
		dutchAuction.setCompanyName(company.getCompanyName());
		GuestRoom guestRoom = guestRoomMapper.selectGuestroomInfo(accommodationName, dutchAuction.getGuestroomName()); //객실 번호를 얻기위한 쿼리 실행
		dutchAuction.setGuestroomNo(guestRoom.getGuestroomNo());
		dutchauctionMapper.insertDutchAuction(dutchAuction); //역경매정보 데이터베이스에 등록
		addDutchAuctionScheduler(dutchAuction);//역경매정보 스케줄러에 추가
	}
	//새로운 객실등록 + 네덜란드식 역경매 등록
	public void addDutchAuctionAndGuestroom(GuestRoom guestRoom, DutchAuction dutchAuction, MultipartFile guestroomImageFile, String path, String memberId, String accommodationName) {
		int accommodationNo = accommodationMapper.selectAccommodationNo(accommodationName); //숙소 번호
		guestRoom.setAccommodationNo(accommodationNo);
		Company company = companyMapper.selectCompanyFromId(memberId);
		guestRoom.setCompanyNo(company.getCompanyNo());
		guestRoom.setCompanyName(company.getCompanyName());
		int imageFileNo = addGuestroomImageFile(guestroomImageFile, path, memberId); //객실 이미지파일정보 데이터베이스에 등록
		guestRoom.setImageFileNo(imageFileNo);
		guestRoomMapper.insertGuestroom(guestRoom); //객실정보 데이터베이스에 등록
		dutchAuction.setAccommodationNo(accommodationNo);
		dutchAuction.setCompanyNo(company.getCompanyNo());
		dutchAuction.setCompanyName(company.getCompanyName());
		dutchAuction.setGuestroomNo(guestRoom.getGuestroomNo());
		dutchauctionMapper.insertDutchAuction(dutchAuction); //역경매정보 데이터베이스에 등록
		addDutchAuctionScheduler(dutchAuction);
	}
	//객실 이미지 등록
	public int addGuestroomImageFile(MultipartFile guestroomImageFile, String path, String memberId) {
		ImageFile imageFile = new ImageFile();
		if(!guestroomImageFile.isEmpty()) {
			imageFile.setMemberId(memberId); //회원 id
			imageFile.setImageFilePath(path); //파일 전체 경로
			String realFileName = guestroomImageFile.getOriginalFilename(); //파일 (이름 + 확장자)
			int index = realFileName.indexOf(".");
			String fileName = realFileName.substring(0,index); //파일 이름
			imageFile.setImageFileRealName(fileName);
			String ext = realFileName.substring(fileName.length()+1, realFileName.length());// 확장자
			imageFile.setImageFileExt(ext);
			imageFile.setImageFileType(guestroomImageFile.getContentType());
			imageFile.setImageFileSize(guestroomImageFile.getSize() / 1024); //파일 크기(KB)
			String storedFileName = UUID.randomUUID().toString(); //저장될 파일 이름(UUID)
			imageFile.setImageFileStoredName(storedFileName);
			imageFile.setFileRegisterTableNo(7); //파일 테이블 번호(PK)
			imageFile.setFileRegisterTableName("객실");
			File folder = new File(path); //폴더 생성을 위한 파일객체
			if(!folder.exists()) {
				folder.mkdirs();
			}
			File storedFile = new File(path + "/" + storedFileName + "." + ext); //실제 저장될 파일객체
			if(imageFileMapper.insertImageFile(imageFile)) {
				try {
					guestroomImageFile.transferTo(storedFile);
				}
				catch(IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
	return imageFile.getImageFileNo();
	}
	public void modifyUpdatePrice(DutchAuction dutchAuction) {
		dutchauctionMapper.updateCurrentPrice(dutchAuction);
	}
}
