package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.BoardDAO;
import com.yedam.vo.Board;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) 
			         throws ServletException, IOException {
		System.out.println("글목록");

		// boardList.do -> BoardListControl -> boardList.jsp
		
		BoardDAO bdao = new BoardDAO();
		List<Board> list = bdao.selectBoard();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("boardList.jsp").forward(req,resp);
		
	}
	
}
