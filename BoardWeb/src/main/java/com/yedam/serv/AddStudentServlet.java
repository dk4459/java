package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

@WebServlet("/addStudentServelet")
public class AddStudentServlet extends HttpServlet{
	StudentDAO sDao = new StudentDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String sno = req.getParameter("std_no"); //empNo의 param에 담겨있는 값 반환.
		String sName = req.getParameter("std_name");
		String tel = req.getParameter("tel_no");
		String addr = req.getParameter("std_addr");
		
		
		boolean result = sDao.addStudent(new Student(sno,sName,tel,addr));
		if(result) {
			resp.sendRedirect("student"); //addEmpServlet -> sample
		}else {
			resp.getWriter().print("처리실패");
		}
	
	}
}
