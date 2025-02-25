package com.yedam.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.dao.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bno = Integer.parseInt(req.getParameter("bno"));
		resp.setContentType("text/json;charset=utf-8");
		
		ReplyDAO rdao = new ReplyDAO();
	   
		List<ReplyVO> rvo = rdao.replyList(bno);
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(rvo);
		
		resp.getWriter().print(json);
	}

}
