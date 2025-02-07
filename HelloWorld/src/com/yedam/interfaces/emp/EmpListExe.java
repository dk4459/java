package com.yedam.interfaces.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.interfaces.Employee;

public class EmpListExe implements EmpDAO {

	List<Employee> employees = new ArrayList<>();
	
	
	

	public EmpListExe() {
		employees.add(new Employee(1001,"홍길동","432-1234"));
		employees.add(new Employee(1002,"김길동","523-2533"));
		employees.add(new Employee(1003,"박길동","674-7544"));
		employees.add(new Employee(1010,"박사장","674-7544","2000-01-01",600));
	}

	@Override
	public boolean registerEmp(Employee emp) {
		return employees.add(emp);
	}

	@Override
	public boolean modifyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (Employee employee : employees) {
			if (employee.getEmpNo() == emp.getEmpNo()) {
				if(!emp.getTelNo().equals("")) {
				employee.setTelNo(emp.getTelNo());
				}
				
				try {
					if(!emp.getHireDate().equals(sdf.parse("1900-01-01"))) {
					employee.setHireDate(emp.getHireDate());
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if(emp.getSalary()!=0) {
				employee.setSalary(emp.getSalary());
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeEmp(int empNo) {
		
		for (int i = 0; i<employees.size();i++) {
			if (employees.get(i).getEmpNo() == empNo) {
				employees.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Employee> search(Employee emp) {
		List<Employee> empAry = new ArrayList<>();
		for (int i = 0; i < employees.size(); i++) {
			if(emp.getSalary()<employees.get(i).getSalary()
				&&employees.get(i).getEmpName().indexOf(emp.getEmpName())!=-1) {
				empAry.add(employees.get(i));
			}
		}
		return empAry;

	}

}
