package com.yedam.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

@WebServlet("/stdInfo")
public class GetStudentServ extends HttpServlet{
	StudentDAO sDao = new StudentDAO();
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		
		String sno = req.getParameter("std_no"); //empNo의 param에 담겨있는 값 반환.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Student std = sDao.selectStd(sno);
		PrintWriter out =res.getWriter(); //출력스트림 생성.
		String str = "<table border='2'>";
		str += "<tr><th>학번</th><th>이름</th><th>전화번호</th><th>주소</th></tr>";
		str +="<tr>"
			+ "<td>"+std.getStudentNo()+"</td>"
			+ "<td>"+std.getStudentName()+"</td>"
			+ "<td>"+std.getPhone()+"</td>"
			+ "<td>"+std.getAddress()+"</td>"
			+ "</tr>";
		out.print(str);
	}
}
