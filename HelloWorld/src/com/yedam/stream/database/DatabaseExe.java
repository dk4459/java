package com.yedam.stream.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ORACLE DB의 접속정보
		String id = "hr";  //oracle 계정 ID
		String password= "hr"; //oracle 계정 비밀번호
		try {
			Connection conn = DriverManager.getConnection(url,id,password);
			System.out.println(conn);
			System.out.println("접속성공");
			//tbl_student 테이블의 조회.
			Statement stmt = conn.createStatement();
			//등록
//		stmt.executeUpdate("insert into tbl_student (student_no, student_name) "
//					          + "values('S008','박현수')");
			//수정
//			int cnt = stmt.executeUpdate("UPDATE tbl_student "
//										+"SET phone = '010-8787-6565' "
//							  			+"WHERE student_name='박현수'");
			//삭제
			int cnt = stmt.executeUpdate("DELETE FROM tbl_student "
										+ "WHERE student_name='박현수'");
			if(cnt > 0) {
				System.out.println("수정이 완료되었습니다.");
			}else {
				System.out.println("수정이 되지 않았습니다.");
			}
			ResultSet rs = stmt.executeQuery("SELECT * "
											+"FROM tbl_student "
											+"ORDER BY student_no");
			//반복문 활용
			while(rs.next()) { // 조회결과 true, 마지막데이터 false
				System.out.println("사원번호: "+rs.getString("student_no")+
								   " 사원이름: "+rs.getString("student_name")+
								   " 사원연락처: "+rs.getString("phone")+
								   " 사원주소: "+rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
