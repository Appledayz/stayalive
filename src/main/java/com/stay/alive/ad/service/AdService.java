package com.stay.alive.ad.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.ad.mapper.AdMapper;
import com.stay.alive.ad.vo.Ad;
import com.stay.alive.ad.vo.AdCost;
import com.stay.alive.ad.vo.AdFile;
import com.stay.alive.ad.vo.AdGroup;

@Service
@Transactional
public class AdService {
	@Autowired
	private AdMapper adMapper;
	
	
	public void adRegister(Ad ad, String realPath) {
		//광고 등록
		String memberId = ad.getMemberId();
		int adCostNo = ad.getAdCostNo();
		int adGroupNo = ad.getAdGroupNo();
		AdCost adCost = adMapper.selectAdCost(adCostNo);
		AdGroup adGroup = adMapper.selectAdGroup(adGroupNo);
		ad.setAdCostNo(adCost.getAdCostNo());
		ad.setAdGroupNo(adGroup.getAdGroupNo());
		ad.setAdGroupName(adGroup.getAdGroupName());
		adMapper.insertAd(ad); // 광고 정보 등록
		//이미지 파일 등록
		MultipartFile multiPartFile = ad.getFile();
		AdFile adFile = new AdFile();
		if(!multiPartFile.isEmpty()) {
			adFile.setMemberId(memberId);
			adFile.setAdFilePath(realPath);
			String realFileName = multiPartFile.getOriginalFilename();
			int index = realFileName.indexOf(".");
			String fileName = realFileName.substring(0, index);
			adFile.setAdFileRealName(fileName);
			String ext = realFileName.substring(fileName.length()+1, realFileName.length());
			adFile.setAdFileExt(ext);
			adFile.setAdFileType(multiPartFile.getContentType());
			adFile.setAdFileSize(multiPartFile.getSize() / 1024);
			String storedFileName = UUID.randomUUID().toString();
			adFile.setAdFileStoredName(storedFileName);
			adFile.setFileRegisterTableNo(5);
			adFile.setFileRegisterTableName("광고");
			//빈파일 생성
			File folder = new File (realPath);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			File file = new File(realPath + "/" + storedFileName + "." + ext);
			adMapper.insertAdFile(adFile); // 파일정보 저장
			try {
				multiPartFile.transferTo(file);
			}
			catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
