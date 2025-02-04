package com.yedam.inheritance;

/*
 * Friend 상속하는 ComFriend
 * 회사명, 부서정보.
 */

public class ComFriend extends Friend {
	private String companyName;
	private String department;

	public ComFriend(String friendName, String phoneNumber,String companyName,String department) {
		super(friendName, phoneNumber);
		this.companyName = companyName;
		this.department = department;
	}

	
	@Override
	public String showInfo() {
		// TODO Auto-generated method stub
		return super.showInfo()+" 회사명: "+ companyName + " 부서: " + department;
	}
	
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	

}
