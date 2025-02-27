package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;

public class ReplyCountControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
//		ReplyDAO rdao = new ReplyDAO();
		int totalCnt = mapper.totalPage(Integer.parseInt(bno));
		
	
		
		//{"totalCnt" : 30}
		resp.getWriter().print("{\"totalCnt\" :"+totalCnt+"}");
	}

}
