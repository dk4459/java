package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;



public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		SqlSession session = sqlSessionFactory.openSession(true);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		BoardVO brd = mapper.detailList(boardNo);
		//세션 아이디 VS 글 작성 아이디
		HttpSession session1 = req.getSession();
		String sessionId = (String) session1.getAttribute("loginId");
		String writeId = brd.getWriter();
		
		if(!sessionId.equals(writeId)) {
			req.setAttribute("msg", "권한을 확인하세요.");
			req.setAttribute("board", brd);
			req.getRequestDispatcher("/board/board.tiles").forward(req, resp);
			return;
		}
		
		req.setAttribute("board", brd);
		req.getRequestDispatcher("/board/modifyBoard.tiles").forward(req, resp);
	}

}
