package com.stay.alive.auction.dutch.service;

import static org.quartz.DateBuilder.dateOf;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
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
	private int groupNum = 0;
	public JobDetail jobDetail() {
		DutchAuction dutchauction = new DutchAuction();
		dutchauction.setAccommodationNo(0);
		JobDataMap jabDataMap = new JobDataMap();
		jabDataMap.put("dutchauction", dutchauction);
		return JobBuilder.newJob(DutchAuctionRegisterJob.class).withIdentity("job"+groupNum)
				.usingJobData(jabDataMap).storeDurably().build();
	}
	public Trigger jobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2).repeatForever();
		return TriggerBuilder.newTrigger().forJob(jobDetail())
				.withIdentity("trigger"+groupNum).endAt(dateOf(3, 50, 0, 23, 12 , 2018)).withSchedule(scheduleBuilder).build();
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

	//객실, 역경매 등록
	public void addDutchAuctionAndGuestroom(GuestRoom guestRoom, DutchAuction dutchAuction, MultipartFile guestroomImageFile, String path, String memberId, String accommodationName) {
		int accommodationNo = accommodationMapper.selectAccommodationNo(accommodationName); //숙소 번호
		guestRoom.setAccommodationNo(accommodationNo);
		Company company = companyMapper.selectCompanyFromId(memberId);
		guestRoom.setCompanyNo(company.getCompanyNo());
		guestRoom.setCompanyName(company.getCompanyName());
		int imageFileNo = addGuestroomImageFile(guestroomImageFile, path, memberId); //객실 이미지파일 등록
		guestRoom.setImageFileNo(imageFileNo);
		//guestRoomMapper.insertGuestroom(guestRoom); //객실 등록
		
		
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
}
