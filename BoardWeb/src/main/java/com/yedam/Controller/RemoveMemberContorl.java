package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.MemberDAO;

public class RemoveMemberContorl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("mid");
		
		MemberDAO mdao = new MemberDAO();
		
		// memberDAO에 삭제. boolean
		boolean isOk = mdao.deleteMember(id);
		
		if(isOk) {
			//{"retCode" : "OK"}
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else {
			//{"retCode" : "NG"}
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		}
	}

}
