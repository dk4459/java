package com.yedam.interfaces.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.interfaces.Employee;

public class EmpDBExe implements EmpDAO{
	// Connection객체.
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "UPDATE tbl_employees\r\n"
				  + "SET tel_no ="+" nvl('"+emp.getTelNo()+"',tel_no),\r\n"
				  + "hire_date ="+ "case to_date('"+sdf.format(emp.getHireDate())+"','yyyy-MM-dd')"
				  + " when to_date('1900-01-01','yyyy-MM-dd') then hire_date "
				  + "else "+"to_date('"+sdf.format(emp.getHireDate())+"','yyyy-MM-dd') end,\r\n"
				  + "salary ="+"case "+emp.getSalary()+
				  " when 0 then salary "
				  + "else "+emp.getSalary()+" end\r\n"
			      + "WHERE emp_no =" + emp.getEmpNo();
		try {			
			Statement stmt =getConnect().createStatement();
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
	public boolean removeEmp(int empNo) {
		String query = "delete from tbl_employees"
					 + " where emp_no = " +empNo;
		try {			
			Statement stmt =getConnect().createStatement();
			int cnt = stmt.executeUpdate(query);
			if(cnt > 0) {
				return true;
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query= "SELECT * "
				+ "FROM tbl_employees "
				+ "WHERE emp_name = nvl('"+emp.getEmpName()+"',emp_name) "
				+ "ORDER BY emp_no";
		try {
			Statement stmt =getConnect().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Employee emp1 = new Employee();
				emp1.setEmpNo(rs.getInt("emp_no"));
				emp1.setEmpName(rs.getString("emp_name"));
				emp1.setTelNo(rs.getString("tel_no"));
				try {
					emp1.setHireDate(rs.getDate("hire_date")==null?sdf.parse("1900-01-01"):rs.getDate("hire_date"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				emp1.setSalary(rs.getInt("salary"));
				
				empList.add(emp1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
}
