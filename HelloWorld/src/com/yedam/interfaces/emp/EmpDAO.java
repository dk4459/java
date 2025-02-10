package com.yedam.interfaces.emp;

import java.util.List;

import com.yedam.interfaces.Employee;

/*
 * 등록, 수정, 삭제, 조회
 * EmpAryExe.java, EmpListExe.java EmpDBExe.java
 */
public interface EmpDAO {
	
	// 등록.
	public boolean registerEmp(Employee emp);
	// 수정.
	public boolean modifyEmp(Employee emp);
	// 삭제.
	public boolean removeEmp(int empNo);
	// 조회
	public List<Employee> search(Employee emp);
}
