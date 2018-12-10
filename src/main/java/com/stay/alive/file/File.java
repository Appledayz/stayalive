package com.stay.alive.file;

import lombok.Data;

@Data
public class File {
	
	private int fileNo; // 파일 번호(PK)
	private String memberId; // 회원 아이디
	private int fileRegisterTableNo; // 파일 등록 테이블 번호(FK)
	private String fileRegisterTableName; // 테이블명
	private String filePath; // 파일 경로
	private String fileRealName; // 파일 이름
	private String fileStoredName; // 저장된 파일 이름
	private String fileExt; // 파일 확장자
	private String fileType; // 파일 형식
	private String fileSize; // 파일 크기
	private String fileRegisterDate; // 파일 등록일
	
}
