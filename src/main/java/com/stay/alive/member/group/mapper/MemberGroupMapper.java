package com.stay.alive.member.group.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.group.vo.MemberGroup;

@Mapper
public interface MemberGroupMapper {
	public List<MemberGroup> selectMemberGroupList();
}
