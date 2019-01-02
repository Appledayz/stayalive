package com.stay.alive.member.option.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.member.option.mapper.MemberOptionMapper;
import com.stay.alive.member.option.vo.MemberOption;

@Service
@Transactional
public class MemberOptionService {
	
	@Autowired 
	private MemberOptionMapper memberOptionMapper;
	
	public List<MemberOption> getMemberOptionList() {
		return memberOptionMapper.selectMemberOptionList();
	}
	
	public void memberOptionRegister(MemberOption memberOption) {
		memberOptionMapper.insertMemberOption(memberOption);
	}
	
	public MemberOption getMemberOption(int memberOptionNo) {
		return memberOptionMapper.selectOneMemberOption(memberOptionNo);
	}
	
	public void memberOptionModify(MemberOption memberOption) {
		memberOptionMapper.updateMemberOption(memberOption);
	}
	
	public void memberOptionRemove(int memberOptionNo) {
		memberOptionMapper.deleteMemberOption(memberOptionNo);
	}
	
}