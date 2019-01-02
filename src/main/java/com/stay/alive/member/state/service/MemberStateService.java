package com.stay.alive.member.state.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.member.state.mapper.MemberStateMapper;
import com.stay.alive.member.state.vo.MemberState;

@Service
@Transactional
public class MemberStateService {
	
	@Autowired 
	private MemberStateMapper memberStateMapper;
	
	public List<MemberState> getMemberStateList() {
		return memberStateMapper.selectMemberStateList();
	}
	
	public void memberStateRegister(MemberState memberState) {
		memberStateMapper.insertMemberState(memberState);
	}
	
	public MemberState getMemberState(int stateNo) {
		return memberStateMapper.selectOneMemberState(stateNo);
	}
	
	public void memberStateModify(MemberState memberState) {
		memberStateMapper.updateMemberState(memberState);
	}
	
	public void memberStateRemove(int stateNo) {
		memberStateMapper.deleteMemberState(stateNo);
	}
	
}
