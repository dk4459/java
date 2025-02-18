package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.Control;

/*
 * MVC에서 Control 역할.
 * url 요청 -> 서블릿
 */

@WebServlet("*.do")
public class FrontController extends HttpServlet{
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>(); // map 필드의 초기화
	}
	
	@Override
	public void init() throws ServletException {
//		map.put("url", "servlet");
		map.put("/boardList.do", new BoardListControl());
		map.put("/addBoard.do", new AddBoardControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI(); //  ex)BoardWeb/addStument.do
		String context = req.getContextPath(); // BoardWeb
		
		String page = uri.substring(context.length());
		
		System.out.println(page);
		
		// map컬렉션에서 key를 입력하면 val반환.
		Control control  = map.get(page);
		control.exec(req,resp);
	}
	
}
