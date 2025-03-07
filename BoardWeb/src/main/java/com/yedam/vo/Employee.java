package com.yedam.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 사원번호(1001, 1002)
 * 사원이름(홍길동, 김민수)
 * 전화번호(654-1123, 654-3434)
 * 입사일자(2020-02-04)
 * 급여(300, 350)
 * 
 * DB에서는 _를 java에서는 _대신해서 대문자를 사용
 */
public class Employee {// tbl_employees
	private int empNo; // emp_no
	private String empName; // emp_name
	private String telNo; // emp_telNo
	private Date hireDate; // hireDate
	private int salary; // salary
	
	// 생성자.
	public Employee() {
	}
	
	public Employee(int empNo, String empName, String telNo) {
		this.empNo = empNo;
		this.empName = empName;
		this.telNo = telNo;
		this.hireDate = new Date();
		this.salary = 250;
	}
	
	public Employee(int empNo, String empName, String telNo, String hireDate, int salary) {
		this(empNo, empName, telNo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.hireDate = sdf.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.salary = salary;
	}
	
	public String empInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 사번   이름     연락처   급여
		//--------------------
		// 1001 홍길동  234-1234 250
		// 1001 홍길동  234-1234 250
		return empNo + "   " + empName + "    " + telNo + "   " + salary + "   " + sdf.format(hireDate);
	}
	
	// getter, setter
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
