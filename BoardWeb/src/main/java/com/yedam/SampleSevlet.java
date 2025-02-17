package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿 생성(http 프로토콜 통해 웹브라우저 출력)
 * 1. HttpServlet을 상속
 * 2. WebApplication(WAS) => tomcat.
 * 3. WAS의 실행 1)init 2)service 3)destroy
 */
public class SampleSevlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출. 최초 한번만 실행.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 호출. 호출마다 실행");
		resp.setContentType("text/html; charset=utf-8");
		EmpDAO emp = new EmpDAO();
		List <Employee> result = new ArrayList<>();	
		result = emp.search(new Employee());
		
		PrintWriter out =resp.getWriter(); //출력스트림 생성.
		for(Employee info : result) {
		System.out.println(info.getEmpName());
		out.print("<a href='/BoardWeb/empInfo?empNo="+info.getEmpNo()+"'><p> 사번: "+info.getEmpNo()+" 이름:"+info.getEmpName()+"</p></a>");
		}
	}
	
	 @Override
	public void destroy() {
		 System.out.println("서버가 종료됩니다.");
	}
}
