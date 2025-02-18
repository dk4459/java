package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends Dao{
	
	
	//등록
	public boolean addStudent(Student std) {
		String sql = "INSERT INTO tbl_student (student_no,student_name,phone,address)"
				   + " values(?,?,?,?)";
		try {
			psmt = getConnect().prepareStatement(sql);
			psmt.setString(1, std.getStudentNo());
			psmt.setString(2, std.getStudentName());
			psmt.setString(3, std.getPhone());
			psmt.setString(4, std.getAddress());
			
			//쿼리실행.
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	// 학생목록을 반환 메소드.
	public List<Student> studentList(){
		List<Student> result = new ArrayList<>();
		String query = "SELECT student_no, student_name, phone, address "
					  + "FROM tbl_student";
		try {
			stmt = getConnect().prepareStatement(query);
			rs = stmt.executeQuery(query);
		while(rs.next()) {
			Student std = new Student();
			std.setStudentNo(rs.getString("student_no"));
			std.setStudentName(rs.getString("student_name"));
			std.setPhone(rs.getString("phone"));
			std.setAddress(rs.getString("address"));
			
			result.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//상세 조회
		public Student selectStd(String stdNo) {
			String query = "SELECT student_no,student_name,phone,address"
						+ " FROM tbl_student "
						+ " WHERE student_no = ?";
			System.out.println(query);
			try {
			
				psmt = getConnect().prepareCall(query);
				psmt.setString(1, stdNo);
				rs = psmt.executeQuery();
				while(rs.next()) {
					Student std = new Student();
					std.setStudentNo(rs.getString("student_no"));
					std.setStudentName(rs.getString("student_name"));
					std.setPhone(rs.getString("phone"));
					std.setAddress(rs.getString("address"));
					return std;
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
