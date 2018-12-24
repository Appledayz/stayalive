package com.stay.alive.auction.dutch.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.company.vo.Company;
import com.stay.alive.guestroom.vo.GuestRoom;

@Mapper 
public interface DutchauctionMapper {
	public String[] selectGuestroomNamefromAccommodationName(String accommodationName);
	public GuestRoom selectGuestroomInfo(String accommodationName, String guestroomName);
	public int selectAccommodationNo(String accommodationName);
	public Company selectCompanyInfo(String memberId);
	
}
