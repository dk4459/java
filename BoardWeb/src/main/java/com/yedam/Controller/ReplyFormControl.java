package com.yedam.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		page = page==null?"1":page;
		resp.setContentType("text/json;charset=utf-8");
		
		//ReplyDAO rdao = new ReplyDAO();
	   
		List<ReplyVO> rvo = mapper.replyList(Integer.parseInt(bno),Integer.parseInt(page));
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(rvo);
		
		resp.getWriter().print(json);
	}

}
