package com.stay.alive.board.vo;

import lombok.Data;

@Data
public class BoardCategory {

	private int boardCategoryNo; // 게시판 카테고리 번호(PK)
	private String boardCategoryName; // 카테고리명(게시판명)
	private String boardCategoryDate; // 카테고리 등록일
	
}
