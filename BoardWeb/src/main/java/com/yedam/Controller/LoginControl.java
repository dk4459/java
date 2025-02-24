package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청방식 (GET/POST)
		// GET일때 반응
	
		if(req.getMethod().equals("GET")) {
			//1.로그인화면
			req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
			//POST일떄 반응
		}else if(req.getMethod().equals("POST")) {
			String id = req.getParameter("uname");
			String pw = req.getParameter("psw");
			//로그인 체크
			MemberDAO mdao = new MemberDAO();
			MemberVO mvo = mdao.login(id, pw);
			HttpSession session = req.getSession();
			session.setAttribute("loginId",id); // attribute활용.
			if(mvo.getReponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}else {
			resp.sendRedirect("main.do");
			}
			
			if(mvo != null) {
				System.out.println("환영합니다."+ mvo.getMemberName());
			}else {
				System.out.println("id, pw 확인.");
			}
		}
		//2. 로그인 기능.
	}

}
