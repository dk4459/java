package com.yedam.vo;
/*
 * 학생이름, 키, 몸무게, 점수
 */
public class Student {
	//field
	private String studentNo;
	private String studentName;
	private String phone;
	private String address;
	
	//생성자
	public Student() {
		
	}

	
	
	
	
	public Student(String studentNo, String studentName, String phone, String address) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.phone = phone;
		this.address = address;
	}





	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	
	
}
