package com.yedam.inheritance;
/*
 * 친구목록 - 일반(이름, 연락처, 혈액형)
 * 		  - 학교(학교의 정보)
 *        - 회사(회사의 정보)
 */
public class Friend {
	
	//필드.
	private String friendName;
	private String phoneNumber;
	private BloodType btype;
	
	//생성자.
	public Friend(String friendName,String phoneNumber) {
		this.friendName = friendName;
		this.phoneNumber = phoneNumber;
		
	}
	
	// 이름, 연락처 보여주기.
	public String showInfo() {
		return "이름"+friendName+", 연락처: "+phoneNumber;
	}
	
	//Getter Setter
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BloodType getBtype() {
		return btype;
	}

	public void setBtype(BloodType btype) {
		this.btype = btype;
	}
	
	
	
}
