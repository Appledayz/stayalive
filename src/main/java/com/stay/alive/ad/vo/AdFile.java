package com.stay.alive.ad.vo;

import lombok.Data;

@Data
public class AdFile {
	// 광고 파일
	private int adFileNo; //광고 파일 번호(PK)
	private String memberId; //회원아이디
	private int adRegisterNo; //광고 등록 번호(FK)
	private String adFilePath; //파일경로
	private String adFileName; //파일이름
	private String adFileExtension; //파일확장자
	private String adFileForm; //파일형식
	private int adFileSize; //파일크기
	private String adFileDate; //파일등록일
}
