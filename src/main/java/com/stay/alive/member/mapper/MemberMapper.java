package com.stay.alive.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.vo.Member;

@Mapper
public interface MemberMapper {
	List<Member> selectMemberAll();
	int insertMember(Member member);
}