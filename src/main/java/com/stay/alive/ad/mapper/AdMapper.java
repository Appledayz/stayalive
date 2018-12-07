package com.stay.alive.ad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.ad.vo.Ad;
@Mapper
public interface AdMapper {
	List<Ad> selectAdAll();
}
