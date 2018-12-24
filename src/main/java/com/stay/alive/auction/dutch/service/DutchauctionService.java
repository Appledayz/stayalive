package com.stay.alive.auction.dutch.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.mapper.AccommodationMapper;
import com.stay.alive.auction.dutch.mapper.DutchauctionMapper;
import com.stay.alive.company.vo.Company;
import com.stay.alive.file.ImageFile;
import com.stay.alive.file.mapper.ImageFileMapper;
import com.stay.alive.guestroom.vo.GuestRoom;

@Service
public class DutchauctionService {
	@Autowired
	private ImageFileMapper imageFileMapper;
	@Autowired
	private AccommodationMapper accommodationMapper;
	@Autowired 
	private DutchauctionMapper dutchauctionMapper;
	public String[] getAccommodationName(String memberId) {
		return accommodationMapper.selectAccommodationName(memberId);
	}
	public String[] getGuestroomNamefromAccommodationName(String accommodationName) {
		return dutchauctionMapper.selectGuestroomNamefromAccommodationName(accommodationName);
	}
	public GuestRoom getGuestroomInfo(String accommodationName, String guestroomName) {
		return dutchauctionMapper.selectGuestroomInfo(accommodationName, guestroomName);
	}
	public int getAccommodationNo(String accommodationName) {
		return dutchauctionMapper.selectAccommodationNo(accommodationName);
	}
	public Company getCompanyInfo(String memberId) {
		return dutchauctionMapper.selectCompanyInfo(memberId);
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
			try {
				guestroomImageFile.transferTo(storedFile);
			}
			catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			imageFileMapper.insertImageFile(imageFile); //이미지 파일정보 데이터베이스에 등록
		}
	return imageFile.getImageFileNo();
	}
}
