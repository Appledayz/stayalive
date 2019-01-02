package com.stay.alive.member.state.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.state.vo.MemberState;

@Mapper
public interface MemberStateMapper {
	
	public List<MemberState> selectMemberStateList();
	public void insertMemberState(MemberState memberState);
	public MemberState selectOneMemberState(int stateNo);
	public void updateMemberState(MemberState memberState);
	public void deleteMemberState(int stateNo);
	
}
