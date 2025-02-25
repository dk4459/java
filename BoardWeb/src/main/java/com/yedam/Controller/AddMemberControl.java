package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.MemberDAO;
import com.yedam.vo.MemberVO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("mid");
		String mpw = req.getParameter("mpw");
		String mname = req.getParameter("mname");
		
		MemberDAO mdao = new MemberDAO();
	    
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setPasswd(mpw);
		mvo.setMemberName(mname);
		
		if(mdao.addMember(mvo)) {
			//{"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			//{"retCode" : "NG"}
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		}
		

	}

}
