package com.stay.alive.member.rating.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.member.rating.vo.MemberRating;

@Mapper
public interface MemberRatingMapper {
	
	public List<MemberRating> selectMemberRatingList();
	public void insertMemberRating(MemberRating memberRating);
	public MemberRating selectOneMemberRating(int ratingNo);
	public void updateMemberRating(MemberRating memberRating);
	public void deleteMemberRating(int ratingNo);
	
}
