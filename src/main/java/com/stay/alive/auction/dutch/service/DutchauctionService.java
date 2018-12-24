package com.stay.alive.auction.dutch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stay.alive.accommodation.mapper.AccommodationMapper;
import com.stay.alive.auction.dutch.mapper.DutchauctionMapper;
import com.stay.alive.company.vo.Company;
import com.stay.alive.guestroom.vo.GuestRoom;

@Service
public class DutchauctionService {
	@Autowired
	private AccommodationMapper accommodationMapper;
	@Autowired 
	private DutchauctionMapper dutchauctionMapper;
	public String[] getAccommodationName(String memberId) {
		return accommodationMapper.selectAccommodationName(memberId);
	}
	public String[] getGuestroomNamefromAccommodationName(String accommodationName) {
		return dutchauctionMapper.selectGuestroomNamefromAccommodationName(accommodationName);
	}
	public GuestRoom getGuestroomInfo(String accommodationName, String guestroomName) {
		return dutchauctionMapper.selectGuestroomInfo(accommodationName, guestroomName);
	}
	public int getAccommodationNo(String accommodationName) {
		return dutchauctionMapper.selectAccommodationNo(accommodationName);
	}
	public Company getCompanyInfo(String memberId) {
		return dutchauctionMapper.selectCompanyInfo(memberId);
	}
	
}
