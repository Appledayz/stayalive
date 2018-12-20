package com.stay.alive.ad.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.ad.vo.Ad;

@Mapper
public interface AdMapper {
	public String selectAdCost(int adCostNo);
	public String selectAdGroup(int adGroupNo);
	public Ad selectAdInfo(String adRegisterNo);
	public ArrayList<Ad> selectAdAll();
	public void insertAd(Ad ad);
	public void updateAd(Ad ad);
}
