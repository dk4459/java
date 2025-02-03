package com.yedam.reference;

/*
 * 아이디, 비밀번호, 이름.
 * 
 * */

public class Member {
	// 필드.
	private String memberId;
	private String password;
	private String memberName;
	
	// 메소드.
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public void setPassWord(String passWord) {
		this.password = passWord;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	

	public String getMemberId() {
		return memberId;
	}


	public String getPassword() {
		return password;
	}


	public String getMemberName() {
		return memberName;
	}


	// 생성자.
	public Member(String memberId, String passWord, String memberName) {
		this.memberId = memberId;
		this.password = passWord;
		this.memberName = memberName;
	}
	
}