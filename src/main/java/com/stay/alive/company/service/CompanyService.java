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
import com.stay.alive.member.group.mapper.MemberGroupMapper;
import com.stay.alive.member.group.vo.MemberGroup;
import com.stay.alive.member.mapper.MemberMapper;
import com.stay.alive.member.vo.Member;

@Service
@Transactional
public class CompanyService {
	
	@Autowired 
	private CompanyMapper companyMapper;
	@Autowired 
	private MemberGroupMapper memberGroupMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	public int checkMemberIdOfCompany(String memberId) {
		if(memberId == null) {
			return 0;
		} else {
			if(companyMapper.selectCompanyFromId(memberId) == null) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
	public void companyRegister(Company company, String realPath) {
		//업체정보 등록
		String memberId = company.getMemberId();
		Member member = new Member();
		member = companyMapper.selectMemberRatingAndOption(memberId);
		company.setRatingNo(member.getRatingNo());
		company.setRatingName(member.getRatingName());
		company.setMemberOptionNo(member.getMemberOptionNo());
		company.setMemberOptionName(member.getMemberOptionName());
		companyMapper.insertCompany(company); //업체 정보 데이터베이스에 등록
		MemberGroup memberGroup = memberGroupMapper.selectOneMemberGroup(4);
		member.setMemberId(memberId);
		member.setGroupNo(memberGroup.getGroupNo());
		member.setGroupName(memberGroup.getGroupName());
		if(memberMapper.updateGroupOfMember(member) == 1) { // 회원그룹 변경(4 - 업체등록자)
			System.out.println("회원그룹 업데이트 성공");
		} else {
			System.out.println("회원그룹 업데이트 실패");
		}
	}
	
	public List<HashMap<String, Object>> getCompanySearchList(HashMap<String, Object> map) {
		PageMaker pageMaker = (PageMaker)map.get("pageMaker");
		int companyListCount = companyMapper.selectMemberAndCompanySearchListCount(map);
		map.put("companyListCount", companyListCount);
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
	
	public Company getCompanyFromId(String memberId) {
		return companyMapper.selectCompanyFromId(memberId);
	}
	//등록한 숙소의 전체 개수를 얻어온다.
	public int getCompanyCount() {
		return companyMapper.selectCompanyCount();
	}
	
	
	public void companyRecognitionModify(int companyNo) {
		companyMapper.updateCompanyRecognition(companyNo); // 업체(호스트) 승인 유무 변경(Y)
		Company company = companyMapper.selectCompanyFromNo(companyNo);
		String memberId = company.getMemberId();
		Member member = new Member();
		MemberGroup memberGroup = memberGroupMapper.selectOneMemberGroup(2);
		member.setMemberId(memberId);
		member.setGroupNo(memberGroup.getGroupNo());
		member.setGroupName(memberGroup.getGroupName());
		if(memberMapper.updateGroupOfMember(member) == 1) { // 회원그룹 변경(2 - 호스트)
			System.out.println("회원그룹 업데이트 성공");
		} else {
			System.out.println("회원그룹 업데이트 실패");
		}
	}
	
}
