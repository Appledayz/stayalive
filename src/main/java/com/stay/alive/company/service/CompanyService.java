package com.stay.alive.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.company.mapper.CompanyMapper;
import com.stay.alive.company.vo.Company;
import com.stay.alive.member.vo.Member;

@Service
@Transactional
public class CompanyService {
	@Autowired 
	private CompanyMapper companyMapper;

	public void companyRegister(Company company) {
		String memberId = company.getMemberId();
		companyMapper.selectMemberRatingAndOption(company);
		companyMapper.insertCompany(company);
	}
}
