package com.stay.alive.member.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.member.rating.mapper.MemberRatingMapper;
import com.stay.alive.member.rating.vo.MemberRating;

@Service
@Transactional
public class MemberRatingService {
	
	@Autowired 
	private MemberRatingMapper memberRatingMapper;
	
	public List<MemberRating> getMemberRatingList() {
		return memberRatingMapper.selectMemberRatingList();
	}
	
	public void memberRatingRegister(MemberRating memberRating) {
		memberRatingMapper.insertMemberRating(memberRating);
	}
	
	public MemberRating getMemberRating(int ratingNo) {
		return memberRatingMapper.selectOneMemberRating(ratingNo);
	}
	
	public void memberRatingModify(MemberRating memberRating) {
		memberRatingMapper.updateMemberRating(memberRating);
	}
	
	public void memberRatingRemove(int ratingNo) {
		memberRatingMapper.deleteMemberRating(ratingNo);
	}
	
}
