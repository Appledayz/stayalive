package com.stay.alive.board.vo;

import lombok.Data;

@Data
public class BoardMember {
	//게시판(회원)
	private int boardMemberNo; //회원 게시글번호(PK)
	private int boardCategoryNo; //게시판 카테고리 번호(FK)
	private String boardCategoryName; //카테고리명(게시판명)
	private String memberId; //회원아이디
	private int groupNo; //회원 그룹 번호(FK)
	private String groupName; //그룹명
	private String boardMemberTitle; //제목
	private String boardMemberContent; //내용
	private String boardMemberSecret; //비밀글
	private String boardMemberRegisterDate; //게시글 등록일자
	private int boardMemberHits; //조회수
	private int boardMemberRecommend; //추천
	private int boardMemberReply; //댓글
	private int boardMemberFile; //파일
	private String boardMemberModifyDate; //게시글 마지막 수정일자
	private int boardStateNo; //게시판 상태 번호(FK)
	private String boardStateName; //상태명
}
