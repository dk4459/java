package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class EmpDAO {
	// Connection객체.
	Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ORACLE DB의 접속정보
		String id = "hr";  //oracle 계정 ID
		String password= "hr"; //oracle 계정 비밀번호
		Connection conn = null;
		try {
		 conn = DriverManager.getConnection(url,id,password);
		 System.out.println("연결성공");
		}catch(Exception e) {
			e.printStackTrace();
			}
			return conn;
		}
//  등록
	public boolean registerEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Statement stmt =getConnect().createStatement();
			String query = "INSERT INTO tbl_employees ";
			query += "values ("+emp.getEmpNo()+",'"+emp.getEmpName()+"','"+
				emp.getTelNo()+"','"+sdf.format(emp.getHireDate())+"',"+emp.getSalary()+")";	
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
//  목록
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query= "SELECT * "
				+ "FROM tbl_employees "
//				+ "WHERE emp_name = nvl('"+empName+"',emp_name) "
				+ "WHERE emp_name = nvl(?, emp_name) "
				+ "ORDER BY emp_no";
		try {
//			Statement stmt =getConnect().createStatement();
			PreparedStatement stmt = getConnect().prepareStatement(query);
			stmt.setString(1, emp.getEmpName()); //첫번째 ?에 사원이름을 대입
			ResultSet rs = stmt.executeQuery();
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
// 상세 조회
	 public Employee selectEmp(int empNo) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 String query = "Select * from tbl_employees ";
		 query += "where emp_no =?";
		 PreparedStatement stmt;
		try {
			stmt = getConnect().prepareStatement(query);
			stmt.setInt(1, empNo); //첫번째 ?에 사원이름을 대입
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
			Employee emp1 = new Employee();
			emp1.setEmpNo(rs.getInt("emp_no"));
			emp1.setEmpName(rs.getString("emp_name"));
			emp1.setTelNo(rs.getString("tel_no"));
			try {
				emp1.setHireDate(rs.getDate("hire_date")==null?sdf.parse("1900-01-01"):rs.getDate("hire_date"));
				} 
			catch (ParseException e) {
					e.printStackTrace();
				}
				emp1.setSalary(rs.getInt("salary"));
			return emp1;	
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	 }
}
