package com.stay.alive.statistics.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.stay.alive.statistics.mapper.StatisticsMapper;
import com.stay.alive.statistics.vo.PieChartData;

@Service
@Transactional
public class StatisticsService {
	@Autowired
	private StatisticsMapper statisticsMapper;
	@Autowired
	private Gson gson;
	
	public JsonArray JsonArray() {
		JsonArray arr = new JsonArray();
		PieChartData guestData = new PieChartData();
		PieChartData hostData = new PieChartData();
		guestData.setLabel("게스트");
		guestData.setData(3);
		hostData.setLabel("호스트");
		hostData.setData(2);
		arr.add(gson.toJson(guestData));
		arr.add(gson.toJson(hostData));
		return arr;
	}
	public ArrayList<String> ArrayListString() {
		ArrayList<String> arr = new ArrayList<String>();
		PieChartData guestData = new PieChartData();
		PieChartData hostData = new PieChartData();
		guestData.setLabel("게스트");
		guestData.setData(3);
		hostData.setLabel("호스트");
		hostData.setData(2);
		arr.add(gson.toJson(guestData));
		arr.add(gson.toJson(hostData));
		return arr;
	}
	public ArrayList<PieChartData> getMemberCount() {
		System.out.println("StatisticService.getMemberCount()");
		ArrayList<PieChartData> list = new ArrayList<PieChartData>();
		PieChartData guestData = new PieChartData();
		PieChartData hostData = new PieChartData();
		guestData.setLabel("게스트");
		guestData.setData(3);
		hostData.setLabel("호스트");
		hostData.setData(2);
		list.add(guestData);
		list.add(hostData);
		return list;
	}

}
