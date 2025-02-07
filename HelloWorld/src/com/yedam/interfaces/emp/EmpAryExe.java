package com.yedam.interfaces.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.interfaces.Employee;

public class EmpAryExe implements EmpDAO{
	Employee[] employees = new Employee[10]; //저장
	
	public EmpAryExe() {
		employees[0] = new Employee(1001,"홍길동","432-1234");
		employees[1] = new Employee(1001,"김길동","433-1235");
		employees[2] = new Employee(1002,"최길동","434-1234");
	}
	
	@Override
	public boolean registerEmp(Employee emp) {
		for(int i = 0; i<employees.length; i++) {
			if(employees[i]==null) {
				employees[i] = emp;
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean modifyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i =0 ; i< employees.length; i++) {
			if(employees[i]!=null&&employees[i].getEmpNo()==emp.getEmpNo()) {
				if(!emp.getTelNo().equals("")) {
				employees[i].setTelNo(emp.getTelNo());
				}
				try {
					if(!emp.getHireDate().equals(sdf.parse("1900-01-01"))) {
					employees[i].setHireDate(emp.getHireDate());
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(emp.getSalary()!=0) {
				employees[i].setSalary(emp.getSalary());
				}
				return true;
			};
			
		}
		return false;
	}
	@Override
	public boolean removeEmp(int empNo) {
		for(int i =0 ; i< employees.length; i++) {
			if(employees[i]!=null&&employees[i].getEmpNo()==empNo);
			employees[i]=null;
			return true;
		}
		
		return false;
	}
	@Override
	public List<Employee> search(Employee emp) {
		List<Employee> empSearch = new ArrayList<>();
		for(int i =0; i< employees.length; i++) {
			if(employees[i] != null &&
			emp.getSalary() < employees[i].getSalary()&&
			employees[i].getEmpName().indexOf(emp.getEmpName())!=-1) {
				empSearch.add(employees[i]);
			}
		}
		
		return empSearch;
	}
	
}
