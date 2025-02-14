package com.yedam.interfaces.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yedam.interfaces.Employee;

public class EmpDBExe implements EmpDAO{
	
	Connection getConnect() {
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ORACLE DB의 접속정보
	String id = "hr";  //oracle 계정 ID
	String password= "hr"; //oracle 계정 비밀번호
	Connection conn = null;
	try {
	 conn = DriverManager.getConnection(url,id,password);

	}catch(Exception e) {
		e.printStackTrace();
		}
		return conn;
	}
	@Override
	public boolean registerEmp(Employee emp) {
		try {
			Statement stmt =getConnect().createStatement();
			String query = "INSERT INTO tbl_employees (emp_no,emp_name,tel_no,salary) ";
			query += "values ("+emp.getEmpNo()+","+emp.getEmpName()+","+
				emp.getTelNo()+","+emp.getSalary()+")";	
			System.out.println(query);
			int cnt = stmt.executeUpdate(query);
			if(cnt > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean modifyEmp(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEmp(int empNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<>();
		try {
			Statement stmt =getConnect().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * "
								+ "FROM tbl_employees "
								+ "WHERE emp_name = nvl('"+emp.getEmpName()+"',emp_name) "
								+ "ORDER BY emp_no");
			while(rs.next()) {
				Employee emp1 = new Employee();
				emp1.setEmpNo(rs.getInt("emp_no"));
				emp1.setEmpName(rs.getString("emp_name"));
				emp1.setHireDate(rs.getDate("hire_date"));
				emp1.setSalary(rs.getInt("salary"));
				
				empList.add(emp1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}
	
}
