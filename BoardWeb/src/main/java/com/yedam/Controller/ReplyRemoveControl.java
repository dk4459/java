package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.ReplyDAO;

public class ReplyRemoveControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rno = req.getParameter("rno");
		
		ReplyDAO rdao = new ReplyDAO();
		
		if(rdao.deleteReply(Integer.parseInt(rno))) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else{
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		};
	}

}
