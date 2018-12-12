package com.stay.alive.accommodation.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.accommodation.vo.Accommodation;
import com.stay.alive.file.ImageFile;

@Service
@Transactional
public class AccommodationService {
	
	
	public void addAccommodation(Accommodation accommodation) {
		
	}
	public String addImageFiles(MultipartFile[] file, String realPath) {
		ImageFile imageFile = new ImageFile();
		 String imageTag = "";
		for(MultipartFile multiPartFile: file) {
			if(!multiPartFile.isEmpty()) {
				imageFile.setMemberId("0"); //회원 id
				imageFile.setImageFilePath(realPath); //파일 전체 경로
				String realFileName = multiPartFile.getOriginalFilename(); //파일 (이름 + 확장자)
				int index = realFileName.indexOf(".");
				String fileName = realFileName.substring(0,index); //파일 이름
				imageFile.setImageFileRealName(fileName);
				String ext = realFileName.substring(fileName.length()+1, realFileName.length());// 확장자
				imageFile.setImageFileExt(ext);
				imageFile.setImageFileType(multiPartFile.getContentType());
				imageFile.setImageFileSize(multiPartFile.getSize() / 1024); //파일 크기(KB)
				String storedFileName = UUID.randomUUID().toString(); //저장될 파일 이름(UUID)
				imageFile.setImageFileStoredName(storedFileName);
				imageFile.setFileRegisterTableNo(3); //숙소 테이블 번호(PK)
				imageFile.setFileRegisterTableName("숙소");
				File folder = new File (realPath); //폴더 생성을 위한 파일객체
				if(!folder.exists()) {
					folder.mkdirs();
				}
				File storedFile = new File(realPath + "/" + storedFileName + "." + ext); //실제 저장될 파일객체
				try {
					multiPartFile.transferTo(storedFile);
				}
				catch(IllegalStateException | IOException e) {
					e.printStackTrace();
				}
				imageTag = imageTag + "<img src=\"/image/accommodation/"   + storedFileName + "." + ext + "\"><br>";

			}
		}
		System.out.println(imageTag);
		return imageTag;
	}
}
