package com.stay.alive.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardReply {

	private int boardReplyNo; // 게시판 댓글 번호(PK)
	private int groupNo; // 회원 그룹 번호(FK)
	private String groupName; // 그룹명
	private int boardNo; // 각 게시판 게시글번호
	private int boardCategoryNo; // 게시글 카테고리 번호
	private String boardReplyIp; // IP주소
	private String memberId; // 회원 아이디
	private String boardReplyContent; // 내용
	private String boardReplySecret; // 비밀댓글
	private String boardReplyDate; // 댓글단 날짜
	
}
