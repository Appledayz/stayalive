package com.stay.alive.company.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.company.vo.Company;
import com.stay.alive.file.ImageFile;
import com.stay.alive.member.vo.Member;

@Mapper
public interface CompanyMapper {
	public void insertCompany(Company company);
	public Member selectMemberRatingAndOption(String memberId);
}
