package com.stay.alive.board.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.stay.alive.board.mapper.BoardMapper;
import com.stay.alive.board.vo.BoardMember;
import com.stay.alive.file.ImageFile;
import com.stay.alive.file.mapper.ImageFileMapper;

@Service
@Transactional
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private ImageFileMapper imageFileMapper;
	
	//게시판 등록
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addBoardMember(BoardMember boardMember, String path) {		
		System.out.println("게시판 등록");
		boardMember.setBoardCategoryNo(1);
		boardMember.setBoardCategoryName("자유게시판");
		
		/*int groupNo = boardMember.getGroupNo();
		String groupName = boardMapper.selectGroupName(groupNo);
		System.out.println(groupName);
		boardMember.setGroupName(groupName);*/
		
		boardMapper.insertBoard(boardMember);
	}
	//게시판 수정
	public void modifyBoard(BoardMember boardMember, String path) {
		removeBoardImageFile(boardMember.getImageFileNo());
		int newFileNo = addBoardFiles(boardMember.getFile(), path, boardMember.getMemberId());
		boardMember.setImageFileNo(newFileNo);
		boardMapper.updateBoard(boardMember);
	}
	//게시판 이름 가져오기
	public String[] getBoardName(String memberId) {
		return boardMapper.selectBoardName(memberId);
	}
	public BoardMember getBoardInfo(String name) {
		return boardMapper.selectBoardInfo(name);
	}
	public BoardMember getBoardFromNo(int boardMemberNo) {
		return boardMapper.selectBoardFromNo(boardMemberNo);
	}
	
	private String addImageFile(ImageFile imageFile, MultipartFile file, String path, String memberId, int ImageFileCategoryNo, String ImageFileCategoryName) {
		String storedFileName = "";
		String ext = "";
		if(!file.isEmpty()) {
			imageFile.setMemberId(memberId); //회원 id
			imageFile.setImageFilePath(path); //파일 전체 경로
			String realFileName = file.getOriginalFilename(); //파일 (이름 + 확장자)
			int index = realFileName.indexOf(".");
			String fileName = realFileName.substring(0,index); //파일 이름
			imageFile.setImageFileRealName(fileName);
			ext = realFileName.substring(fileName.length()+1, realFileName.length());// 확장자
			imageFile.setImageFileExt(ext);
			imageFile.setImageFileType(file.getContentType());
			imageFile.setImageFileSize(file.getSize() / 1024); //파일 크기(KB)
			storedFileName = UUID.randomUUID().toString(); //저장될 파일 이름(UUID)
			imageFile.setImageFileStoredName(storedFileName);
			imageFile.setImageFileCategoryNo(ImageFileCategoryNo); //파일 테이블 번호(PK)
			imageFile.setImageFileCategoryName(ImageFileCategoryName);
			File folder = new File (path); //폴더 생성을 위한 파일객체
			if(!folder.exists()) {
				folder.mkdirs();
			}
			File storedFile = new File(path + "/" + storedFileName + "." + ext); //실제 저장될 파일객체
			try {
				file.transferTo(storedFile);
			}
			catch(IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return "<img style=\"width:300px;height:300px\" src=\"/image/board/" + storedFileName + "." + ext + "\">";
	}
	public String addDetailImageFiles(MultipartFile[] multipartFile, String path, String memberId) {
		String imageTag = "";
		ImageFile imageFile = new ImageFile();
		imageFile.setMemberId(memberId); //임시로 회원아이디 세팅
		for(MultipartFile file: multipartFile) {
			if(!file.isEmpty()) {
				imageTag = imageTag + addImageFile(imageFile, file, path, memberId, 2, "게시판");
				imageFileMapper.insertImageFile(imageFile);
			}
		}
		return imageTag;
	}
	public int addBoardFiles(MultipartFile file, String path, String memberId) {
		ImageFile imageFile = new ImageFile();
		addImageFile(imageFile, file, path, memberId, 2, "게시판");
		imageFileMapper.insertImageFile(imageFile);
		return imageFile.getImageFileNo();
	}
	//사진 파일 삭제
	public void removeBoardImageFile(int imageFileNo) {
		ImageFile imageFile = imageFileMapper.selectImageFile(imageFileNo);
		imageFileMapper.deleteImageFile(imageFileNo); //데이터베이스 -> 이미지파일 정보 삭제
		String path =imageFile.getImageFilePath();
		String ext = imageFile.getImageFileExt();
		String stordName = imageFile.getImageFileStoredName();
		File file = new File(path + "/" + stordName + "." + ext);
		System.out.println(path + "/" + stordName + "." + ext);
		file.delete(); //실제 저장된 파일 삭제
	}
	//게시글 리스트
	public ArrayList<BoardMember> getBoardAll(){
		return boardMapper.selectBoardAll();
	}
	//게시글 삭제
	public int removeBoard(int boardMemberNo) {
		int i=0;
		i+= boardMapper.deleteBoard(boardMemberNo);
		return i;
	}
}
