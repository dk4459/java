package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.ReplyDAO;
import com.yedam.mapper.ReplyMapper;

public class ReplyRemoveControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rno = req.getParameter("rno");
		SqlSession session = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
//		ReplyDAO rdao = new ReplyDAO();
		
		if(mapper.deleteReply(Integer.parseInt(rno))>0) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else{
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		};
	}

}
