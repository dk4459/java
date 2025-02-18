package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.EmpDAO;
import com.yedam.vo.Employee;

//init - service - destroy :서블릿의 생명주기.
@WebServlet("/addEmpServelet")
public class AddEmployeeServ extends HttpServlet{
	EmpDAO eDao = new EmpDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		int eno = Integer.parseInt(req.getParameter("empNo")); //empNo의 param에 담겨있는 값 반환.
		String eName = req.getParameter("empName");
		String tel = req.getParameter("telNo");
		
		
		boolean result = eDao.registerEmp(new Employee(eno,eName,tel));
		if(result) {
			resp.getWriter().print("처리성공");
			//resp.sendRedirect("sample"); //addEmpServlet -> sample
		}else {
			resp.getWriter().print("처리실패");
		}
	}
}
