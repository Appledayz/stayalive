package com.stay.alive.company.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.company.vo.Company;
import com.stay.alive.member.vo.Member;

@Mapper
public interface CompanyMapper {
	public void insertCompany(Company company);
	public Member selectMemberRatingAndOption(String memberId);
	public int selectCompanySearchListCount(HashMap<String, Object> map);
	public List<Company> selectCompanySearchList(HashMap<String, Object> map);
}
