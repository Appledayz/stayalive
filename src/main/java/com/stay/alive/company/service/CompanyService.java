package com.stay.alive.company.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.company.mapper.CompanyMapper;
import com.stay.alive.company.vo.Company;
import com.stay.alive.file.ImageFile;
import com.stay.alive.member.vo.Member;

@Service
@Transactional
public class CompanyService {
	@Autowired 
	private CompanyMapper companyMapper;
	
	public void companyRegister(Company company, String realPath) {
		//업체정보 등록
		String memberId = company.getMemberId();
		Member member = companyMapper.selectMemberRatingAndOption(memberId);
		company.setRatingNo(member.getRatingNo());
		company.setRatingName(member.getRatingName());
		company.setMemberOptionNo(member.getMemberOptionNo());
		company.setMemberOptionName(member.getMemberOptionName());
		companyMapper.insertCompany(company); //업체 정보 데이터베이스에 등록
		//이미지파일 등록
		MultipartFile multiPartFile = company.getImageFile();
		ImageFile imageFile = new ImageFile();
		System.out.println(realPath);
		if(!multiPartFile.isEmpty()) {
			imageFile.setMemberId(memberId);
			imageFile.setImageFilePath(realPath);
			String realFileName = multiPartFile.getOriginalFilename();
			int index = realFileName.indexOf(".");
			String fileName = realFileName.substring(0,index);
			imageFile.setImageFileRealName(fileName);
			String ext = realFileName.substring(fileName.length()+1, realFileName.length());
			imageFile.setImageFileExt(ext);
			imageFile.setImageFileType(multiPartFile.getContentType());
			imageFile.setImageFileSize(multiPartFile.getSize() / 1024);
			String storedFileName = UUID.randomUUID().toString();
			imageFile.setImageFileStoredName(storedFileName);
			imageFile.setFileRegisterTableNo(4);
			imageFile.setFileRegisterTableName("업체");
			//빈파일 생성
			File folder = new File (realPath);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			File file = new File(realPath + "/" + storedFileName + "." + ext);
			companyMapper.insertCompanyImageFile(imageFile); //이미지 파일 정보 데이터베이스에 저장
			//multipartFile파일을 빈파일로 복사
			try {
				multiPartFile.transferTo(file);
			}
			catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
