package com.stay.alive.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardNonmember {
	//게시판(비회원)
	private int boardNonmemberNo; //비회원 게시글번호(PK)
	private int boardCategoryNo; //게시판 카테고리 번호(FK)
	private int boardCategoryName; //카테고리명(게시판명)
	private int boardNonmemberPassword; //게시글 패스워드
	private int boardNonmemberTitle; //제목
	private int boardNonmemberContent; //내용
	private int boardNonmemberIp; //IP주소
	private int boardNonmemberRegisterDate; //게시글 등록일자
	private int boardNonmemberHits; //조회수
	private int boardNonmemberRecommend; //추천
	private int boardNonmemberReply; //댓글
	private int boardNonmemberFile; //파일
	private int boardNonmemberModifyDate; //게시글 마지막 수정일자
	private int boardStateNo; //게시판 상태 번호(FK)
	private int boardStateName; //상태명
}
