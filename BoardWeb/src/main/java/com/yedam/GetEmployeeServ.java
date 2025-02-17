package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/empInfo")
public class GetEmployeeServ extends HttpServlet{
	EmpDAO eDao = new EmpDAO();
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=UTF-8");
		int eno = Integer.parseInt(req.getParameter("empNo")); //empNo의 param에 담겨있는 값 반환.
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Employee emp = eDao.selectEmp(eno);
		PrintWriter out =res.getWriter(); //출력스트림 생성.
		String str = "<table border='2'>";
		str += "<tr><th>사번</th><th>이름</th><th>전화번호</th><th>입사일</th><th>금액</th></tr>";
		str +="<tr>"
			+ "<td>"+emp.getEmpNo()+"</td>"
			+ "<td>"+emp.getEmpName()+"</td>"
			+ "<td>"+emp.getTelNo()+"</td>"
			+ "<td>"+sdf.format(emp.getHireDate())+"</td>"
			+ "<td>"+emp.getSalary()+"원</td>"
			+ "</tr>";
		out.print(str);
		
	}
}
