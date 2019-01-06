package com.stay.alive.statistics.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticsMapper {
	int selectGuestCount();
	int selectHostCount();
}
