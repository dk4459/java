package com.yedam.inheritance;

public class UnivFriend extends Friend{
    //필드
	
	private String univName;
	private String univmajor;
	private BloodType btype;
	
	//생성자
	public UnivFriend(String friendName, String phoneNumber, String univName, String univmajor) {
		super(friendName,phoneNumber);
		this.univName = univName;
		this.univmajor = univmajor;
	}


	@Override
	public String showInfo() {
		// TODO Auto-generated method stub
		return super.showInfo()+" 대학명: "+ univName + " 전공: " + univmajor;
	}
	
	public String getUnivName() {
		return univName;
	}


	public void setUnivName(String univName) {
		this.univName = univName;
	}


	public String getUnivmajor() {
		return univmajor;
	}


	public void setUnivmajor(String univmajor) {
		this.univmajor = univmajor;
	}
	
	
	
	
}
