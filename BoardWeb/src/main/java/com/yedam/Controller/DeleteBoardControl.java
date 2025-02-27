package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;

public class DeleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession session = sqlSessionFactory.openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		int bno = Integer.parseInt(req.getParameter("boardNo"));
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		String page = req.getParameter("page");
		
		
		if(mapper.deleteBoard(bno)>0) {
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+searchCondition+"&keyword="+keyword);
		};
	}

}
