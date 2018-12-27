package com.stay.alive.board.mapper;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.stay.alive.board.vo.BoardMember;

@Mapper
public interface BoardMapper {
	public void insertBoard(BoardMember boardMember);
	public String selectCategoryName(int boardCategoryNo);
	public void updateBoard(BoardMember boardMember);
	public String[] selectBoardName(String memberId);
	public BoardMember selectBoardInfo(String name);
	public BoardMember selectBoardFromNo(int boardMemberNo);
	public int selectBoardNo(String BoardName);
	public ArrayList<BoardMember> selectBoardAll();
	public int deleteBoard(int boardMemberNo);
}
