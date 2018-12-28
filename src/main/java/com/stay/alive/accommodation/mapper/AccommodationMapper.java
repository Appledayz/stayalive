package com.stay.alive.accommodation.mapper;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.accommodation.vo.Accommodation;

@Mapper
public interface AccommodationMapper {
	public void insertAccommodation(Accommodation accommodation);
	public boolean selectSidoName(String addressSidoName);
	public boolean selectSigunguName(String addressSigunguName);
	public void insertSidoName(String addressSidoName);
	public void insertSigunguName(String addressSigunguName);
	public String selectCategoryName(int accommodationCategoryNo);
	public String[] selectAccommodationName(String memberId);
	public Accommodation selectAccommodationInfo(String name);
	public void updateAccommodation(Accommodation accommodation);
	public ArrayList<Accommodation> selectAccommodationAll();
	public Accommodation selectAccommodationFromNo(int accommodationNo);
	public int selectAccommodationNo(String AccommodationName);
	public void updateAccommodationRecognition(int accommodationNo);
}
