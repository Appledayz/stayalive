package com.stay.alive.ad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stay.alive.ad.mapper.AdMapper;

@Service
@Transactional
public class AdService {
	@Autowired
	private AdMapper adMapper;
	
	// 광고 목록 조회

}
