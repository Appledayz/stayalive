package com.stay.alive.member.option.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.option.vo.MemberOption;

@Mapper
public interface MemberOptionMapper {
	
	public List<MemberOption> selectMemberOptionList();
	public void insertMemberOption(MemberOption memberOption);
	public MemberOption selectOneMemberOption(int memberOptionNo);
	public void updateMemberOption(MemberOption memberOption);
	public void deleteMemberOption(int memberOptionNo);
	
}