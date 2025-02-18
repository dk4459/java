package com.yedam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dao {
	Connection conn = null;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ORACLE DB의 접속정보
		String id = "hr";  //oracle 계정 ID
		String password= "hr"; //oracle 계정 비밀번호
		
		try {
		 conn = DriverManager.getConnection(url,id,password);
		 System.out.println("연결성공");
		}catch(Exception e) {
			e.printStackTrace();
			}
			return conn;
		}
}
