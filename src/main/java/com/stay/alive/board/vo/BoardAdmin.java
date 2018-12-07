package com.stay.alive.board.vo;

import lombok.Data;

@Data
public class BoardAdmin {
	
	private int boardAdminNo; // 관리자 게시글번호(PK)
	private int boardCategoryNo; // 게시판 카테고리 번호(FK)
	private String boardCategoryName; // 카테고리명(게시판명)
	private String memberId; // 관리자아이디
	private int groupNo; // 회원 그룹 번호(FK)
	private String groupName; // 그룹명
	private String boardAdminTitle; // 제목
	private String boardAdminContent; // 내용
	private String boardAdminRegisterDate; // 게시글 등록일자
	private int boardAdminHits; // 조회수
	private int boardMemberRecommemnd; // 추천
	private int boardMemberFile; // 파일 
	private String boardMemberModifyDate; // 게시글 마지막 수정일자
	private int boardStateNo; //게시판 상태 번호(FK)
	private String boardStateName; // 상태명
	
}
