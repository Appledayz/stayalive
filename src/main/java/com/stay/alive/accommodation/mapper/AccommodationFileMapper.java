package com.stay.alive.accommodation.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.file.ImageFile;

@Mapper
public interface AccommodationFileMapper {
	public void insertImageFile(ImageFile imageFile);
}
