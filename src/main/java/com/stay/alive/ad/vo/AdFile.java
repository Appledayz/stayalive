package com.stay.alive.ad.vo;

import lombok.Data;

@Data
public class AdFile {
	// 광고 파일
	private int adFileNo; //광고 파일 번호(PK)
	private String memberId; //회원아이디
	private int adRegisterNo; //광고 등록 번호(FK)
	private int fileRegisterTableNo; //파일 등록 테이블 번호(FK)
	private String adFilePath; //파일경로
	private String adFileStoredName; //저장될 파일 이름
	private String adFileRealName; //오리지널 파일 이름
	private String adFileExt; //파일확장자
	private String adFileType; //파일타입
	private long adFileSize; //파일크기
	private String adFileDate; //파일등록일
}
