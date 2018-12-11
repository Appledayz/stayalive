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
	}
}
