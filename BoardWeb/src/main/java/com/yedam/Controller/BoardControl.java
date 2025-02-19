package com.yedam.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		
		BoardDAO bDAO = new BoardDAO();
		
		//조회수증가
		bDAO.viewCnt(boardNo);
		
		BoardVO brd = bDAO.detailList(boardNo);
		
		req.setAttribute("board", brd);
		
		req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
	}

}
