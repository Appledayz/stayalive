package com.stay.alive.member.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.group.vo.MemberGroup;

@Mapper
public interface MemberGroupMapper {
	
	public List<MemberGroup> selectMemberGroupList();
	public void insertMemberGroup(MemberGroup memberGroup);
	public MemberGroup selectOneMemberGroup(int groupNo);
	public void updateMemberGroup(MemberGroup memberGroup);
	public void deleteMemberGroup(int groupNo);
	
}
