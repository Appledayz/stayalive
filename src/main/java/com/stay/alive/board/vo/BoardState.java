package com.stay.alive.board.vo;

import lombok.Data;

@Data
public class BoardState {

	private int boardStateNo; // 게시판 상태 번호(PK)
	private String boardStateName; // 상태명
	private String boardStateDate; // 상태 등록일자
	
}
