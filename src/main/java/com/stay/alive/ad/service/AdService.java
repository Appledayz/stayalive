package com.stay.alive.ad.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.ad.mapper.AdFileMapper;
import com.stay.alive.ad.mapper.AdMapper;
import com.stay.alive.ad.vo.Ad;
import com.stay.alive.ad.vo.AdFile;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AdService {
	@Autowired
	private AdMapper adMapper;
	@Autowired
	private AdFileMapper adFileMapper;
	
	//광고 파일 추가
	private String addAdFile(AdFile adFile, MultipartFile file, String path, String memberId, int fileRegisterTableNo, String registerTableName) {
		String storedFileName = "";
		String ext = "";
		if(!file.isEmpty()) {
			adFile.setMemberId(memberId); //회원 id
			adFile.setAdFilePath(path); //파일 전체 경로
			String realFileName = file.getOriginalFilename(); //파일 (이름 + 확장자)
			int index = realFileName.indexOf(".");
			String fileName = realFileName.substring(0,index); //파일 이름
			adFile.setAdFileRealName(fileName);
			ext = realFileName.substring(fileName.length()+1, realFileName.length());// 확장자
			adFile.setAdFileExt(ext);
			adFile.setAdFileType(file.getContentType());
			adFile.setAdFileSize(file.getSize() / 1024); //파일 크기(KB)
			storedFileName = UUID.randomUUID().toString(); //저장될 파일 이름(UUID)
			adFile.setAdFileStoredName(storedFileName);
			adFile.setFileRegisterTableNo(fileRegisterTableNo); //파일 테이블 번호(PK)
			adFile.setFileRegisterTableName(registerTableName);
			File folder = new File (path); //폴더 생성을 위한 파일객체
			if(!folder.exists()) {
				folder.mkdirs();
			}
			File storedFile = new File(path + "/" + storedFileName + "." + ext); //실제 저장될 파일객체
			try {
				file.transferTo(storedFile);
			}
			catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return "<img src=\"/image/ad/" + storedFileName + "." + ext + "\">";
	}
	//광고 파일 추가2
	public int addAdFiles(MultipartFile file, String path, String memberId) {
		AdFile adFile = new AdFile();
		addAdFile(adFile, file, path, memberId, 5, "광고");
		adFileMapper.insertImageFile(adFile);
		return adFile.getAdFileNo();
	}
	//광고 등록
	public void addAd(Ad ad, String path) {
		int adFileNo = addAdFiles(ad.getFile(), path, ad.getMemberId());
		ad.setAdFileNo(adFileNo);
		adMapper.insertAd(ad);
	}
	//광고 파일 삭제
	public void removeAdFile(int adFileNo) {
		AdFile adFile = adFileMapper.selectImageFile(adFileNo);
		adFileMapper.deleteImageFile(adFileNo);
		String path = adFile.getAdFilePath();
		String ext = adFile.getAdFileExt();
		String stordName = adFile.getAdFileStoredName();
		File file = new File(path + "/" + stordName + "." + ext);
		file.delete();
	}
	
	//광고 리스트
	public ArrayList<Ad> getAdAll(){
		return adMapper.selectAdAll();
	}
	
	//광고 수정
	
	
	
	
}
