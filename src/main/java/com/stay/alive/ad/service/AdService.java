package com.stay.alive.ad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.ad.mapper.AdMapper;
import com.stay.alive.ad.vo.Ad;

@Service
@Transactional
public class AdService {
	@Autowired
	private AdMapper adMapper;
	
	// 1.광고 전체 목록
	public List<Ad> getAdList(){
		return adMapper.selectAdAll();
	}
	// 2.광고 목록 검색
	public List<Ad> getAdSearchList(String sk, String sv){
		return adMapper.selectAdSearchList(sk, sv);
	}
	// 3.광고 상세 보기
	public Ad getAdDetail(int adRegisterNo) {
		return adMapper.selectAdOne(adRegisterNo);
	}
	// 4.광고 등록 폼
	public int addAdForm(Ad ad) {
		return adMapper.insertAd(ad);
	}
	// 5.광고 수정 폼
	public Ad modifyAdForm(int adRegisterNo) {
		return adMapper.selectAdOne(adRegisterNo);
	}
	// 6.광고 수정 액션
	public int modifyAdAction(Ad ad) {
		return adMapper.updateAd(ad);
	}
	// 7.광고 삭제
	//public Ad removeAd() 
}
