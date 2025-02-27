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
import com.yedam.vo.BoardVO;



public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession session = sqlSessionFactory.openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		BoardVO bvo = new BoardVO();
		bvo.setBoardNo(boardNo);
		bvo.setTitle(title);
		bvo.setContent(content);
		
		if(mapper.updateBoard(bvo)>0) {
			req.setAttribute("board", bvo);
			req.getRequestDispatcher("/board/board.tiles").forward(req, resp);
		}else {
			System.out.println("실패");
		}
		
	}

}
