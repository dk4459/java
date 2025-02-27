package com.yedam.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		 String reply = req.getParameter("reply");
		 String replyer = req.getParameter("replyer");
		 int boardNo = Integer.parseInt(req.getParameter("bno"));
		
//		ReplyDAO rdao = new ReplyDAO();
		ReplyVO rvo = new ReplyVO();
		
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		rvo.setBoardNo(boardNo);
		
		Map<String,Object> result = new HashMap<>();
		
		if(mapper.insertReply(rvo)>0) {
			result.put("retCode", "OK");
			result.put("retVal", rvo);
		}else{
			result.put("retCode", "NG");
		};
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);
		resp.getWriter().print(json);
	}
}
