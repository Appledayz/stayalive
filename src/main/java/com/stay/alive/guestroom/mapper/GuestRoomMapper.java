package com.stay.alive.guestroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.stay.alive.guestroom.vo.GuestRoom;

@Mapper
public interface GuestRoomMapper {
	public String[] selectGuestroomNames(String accommodationName);
	public GuestRoom selectGuestroomInfo(String accommodationName, String guestroomName);
	public void insertGuestroom(GuestRoom guestRoom);
	public int selectGuestroomCount();
}
