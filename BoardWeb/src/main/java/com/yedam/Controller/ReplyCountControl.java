package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;

public class ReplyCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		System.out.println("비엔오"+bno);
		ReplyDAO rdao = new ReplyDAO();
		int totalCnt = rdao.totalPage(Integer.parseInt(bno));
		
	
		
		//{"totalCnt" : 30}
		resp.getWriter().print("{\"totalCnt\" :"+totalCnt+"}");
	}

}
