package com.stay.alive.member.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.member.group.mapper.MemberGroupMapper;
import com.stay.alive.member.group.vo.MemberGroup;

@Service
@Transactional
public class MemberGroupService {
	
	@Autowired 
	private MemberGroupMapper memberGroupMapper;
	
	public List<MemberGroup> getMemberGroupList() {
		return memberGroupMapper.selectMemberGroupList();
	}
	
	public void memberGroupRegister(MemberGroup memberGroup) {
		memberGroupMapper.insertMemberGroup(memberGroup);
	}
	
	public MemberGroup getMemberGroup(int groupNo) {
		return memberGroupMapper.selectOneMemberGroup(groupNo);
	}
	
	public void memberGroupModify(MemberGroup memberGroup) {
		memberGroupMapper.updateMemberGroup(memberGroup);
	}
	
	public void memberGroupRemove(int groupNo) {
		memberGroupMapper.deleteMemberGroup(groupNo);
	}
	
}
