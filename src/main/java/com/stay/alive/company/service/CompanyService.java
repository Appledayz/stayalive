package com.stay.alive.company.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.common.PageMaker;
import com.stay.alive.common.PageMakerService;
import com.stay.alive.company.mapper.CompanyMapper;
import com.stay.alive.company.vo.Company;
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
	
	public List<HashMap<String, Object>> getCompanySearchList(HashMap<String, Object> map) {
		PageMaker pageMaker = (PageMaker)map.get("pageMaker");
		int companyListCount = companyMapper.selectMemberAndCompanySearchListCount(map);
		map.put("companyListCount", companyListCount);
		pageMaker.setRowPerPage(10);
		pageMaker.setPagePerBlock(10);
		pageMaker.setAllCount(companyListCount);
		pageMaker = PageMakerService.pageMakerService(pageMaker);
		return companyMapper.selectMemberAndCompanySearchList(map);
	}
	
	public Company getCompanyFromNo(int companyNo) {
		return companyMapper.selectCompanyFromNo(companyNo);
	}
	
	public List<Company> getCompanyList() {
		return companyMapper.selectCompanyList();
	}
	
}
