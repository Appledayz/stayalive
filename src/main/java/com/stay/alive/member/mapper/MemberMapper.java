package com.stay.alive.member.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.vo.Member;

@Mapper
public interface MemberMapper {
/*	List<Member> selectMemberAll(HashMap<String, Object>map);
	int selectMemberAllCount();
	
	public abstract Member selectMemberOne(int memberNo);
	*/
	int insertMember(Member member);
	int selectCountMemberAll();
	List<Member> selectMember(HashMap<String, Integer> pagingInfo);
	Member idCheck(Member memberId);
	Member nicknameCheck(Member memberNickname);
}