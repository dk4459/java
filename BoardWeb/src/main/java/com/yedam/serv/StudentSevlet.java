package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

@WebServlet("/student")
public class StudentSevlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 호출. 호출마다 실행");
		resp.setContentType("text/html; charset=utf-8");
		StudentDAO std = new StudentDAO();
		List <Student> result = new ArrayList<>();	
		result = std.studentList();
		
		PrintWriter out =resp.getWriter(); //출력스트림 생성.
		for(Student info : result) {
		out.print("<a href='/BoardWeb/stdInfo?std_no="+info.getStudentNo()+"'><p> 학번: "+info.getStudentNo()+" 이름:"+info.getStudentName()+"</p></a>");
		}
	}
}
