package com.stay.alive.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.vo.Member;

@Mapper
public interface LoginMapper {
	int memberLogin(Member member);
}