package com.stay.alive.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.login.vo.LoginVo;

@Mapper
public interface LoginMapper {
	LoginVo selectLogin(LoginVo loginVo);
	String selectMemberSaltFromId(String memberId);
}