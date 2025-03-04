package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;

public class DeleteDate implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession session = sqlSessionFactory.openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		end=end==null?"":end;
		
		
		
		if(mapper.deleteEvent(title,start,end)>0) {
			resp.getWriter().print("{\"retCode\" : \"OK\"}");
		}else{
			resp.getWriter().print("{\"retCode\" : \"NG\"}");
		};
	}

}
