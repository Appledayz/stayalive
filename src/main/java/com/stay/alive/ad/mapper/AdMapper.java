package com.stay.alive.ad.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.ad.vo.Ad;
import com.stay.alive.ad.vo.AdCost;
import com.stay.alive.ad.vo.AdFile;
import com.stay.alive.ad.vo.AdGroup;
@Mapper
public interface AdMapper {
	public void insertAd(Ad ad);
	public void insertAdFile(AdFile adFile);
	public AdCost selectAdCost(int adCostNo);
	public AdGroup selectAdGroup(int adGroupNo);
}
