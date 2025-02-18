package com.yedam;

import java.util.List;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

public class Test {
	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAO();
		List<Student> result = sdao.studentList();
		
		for(Student std : result) {
			System.out.println("학번: "+std.getStudentNo());
			System.out.println("이름: "+std.getStudentName());
			System.out.println("전화번호: "+std.getPhone());
			System.out.println("주소: "+std.getAddress());
		}
	}
	
	
}
