package com.stay.alive.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	//회원가입시 직접입력
	private String memberId;//아이디(UN)
	private String memberPassword;//비밀번호
	private String memberName;//이름
	private String memberNickname;//닉네임
	private String memberBirth;//생일
	private int memberPhoneNumber1;//전화번호1
	private String memberEmail;//이메일
	private String memberHomepage;//홈페이지
	private String memberEmailAccept;//이메일 수신동의
	private String memberSmsAccept;//SMS수신 동의
	
	//회원 가입 이후 변경되는 조건
	private int memberStateNo;//회원 상태 번호(FK)
	private String memberStateName;//상태명
	private String memberGroup;//회원 그룹
	private String memberGroupName;//그룹명
	private int memberRatingNo;//회원 등급(FK)
	private String memberRatingName;//등급명
	private int memberOptionNo;//회원 옵션
	private String memberOptionName;//옵션명
	
	//관리자 권한으로 조회가능
	private String memberRegisterDate;//가입일자
	private String memberLastupdateDate;//마지막 정보수정일자
	private String memberLastlogoutDate;//마지막 로그아웃일자
	private String memberLastloginDate;//마지막 로그인일자
	private int memberLoginCount;//로그인 횟수
	
	//private int memberPaxNumber;//팩스
	//private String memberComment;//메시지
	//private String memberBirthYear;//생년
	//private String memberBirthMonth;//생월
	//private String memberBirthDay;//생일
	//private String memberCalendar;//양력/음력
	//private String memberGender;//성별
	//private String memberPhoneNumber2;//전화번호2
	//private String memberPhoneNumber3;//전화번호3
	//private String memberZipcode;//우편번호
	//private String memberAddress1;//주소1
	//private String memberAddress2;//주소2
	//private String StringmemberSnsId;//sns
	//private String memberInfoPublic;//정보공개여부
}
