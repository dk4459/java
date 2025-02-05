package com.yedam.interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 사원번호(1001,1002)
 * 사원이름(홍길동,김민수)
 * 전화번호
 * 입사일자
 * 급여
 */
public class Employee {
	private int empNo;
	private String empName;
	private String telNo;
	private Date hireDate;
	private int salary;
	
	public Employee() {}
	
	public Employee(int empNo, String empName, String telNo) {
		
		this.empNo = empNo;
		this.empName = empName;
		this.telNo = telNo;
		this.hireDate = new Date();
		this.salary = 250;
	}
	public Employee(int empNo, String empName, String telNo, String hireDate,int salary) {
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
	
	
	//Getter Setter
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
