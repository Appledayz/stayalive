package com.stay.alive.file.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.file.ImageFile;

@Mapper
public interface ImageFileMapper {
	public boolean insertImageFile(ImageFile imageFile);
	public ImageFile selectImageFile(int imageFileNo);
	public void deleteImageFile(int imageFileNo);
}
