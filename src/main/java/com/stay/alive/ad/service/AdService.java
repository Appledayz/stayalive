package com.stay.alive.ad.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stay.alive.ad.mapper.AdFileMapper;
import com.stay.alive.ad.mapper.AdMapper;
import com.stay.alive.ad.vo.Ad;
import com.stay.alive.ad.vo.AdFile;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AdService {
	@Autowired
	private AdMapper adMapper;
	@Autowired
	private AdFileMapper adFileMapper;
	
	//광고 리스트
	public ArrayList<Ad> getAdAll(){
		return adMapper.selectAdAll();
	}
	
	
}
