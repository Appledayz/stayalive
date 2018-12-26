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
	
}
