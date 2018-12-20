package com.stay.alive.ad.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.ad.vo.AdFile;

@Mapper
public interface AdFileMapper {
	public void insertImageFile(AdFile adFile);
	public AdFile selectImageFile(int adFileNo);
	public void deleteImageFile(int adFileNo);
}
